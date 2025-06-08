package com.biapay.core.service;

import com.biapay.core.dto.BillForDefaultPlanDTO;
import com.biapay.core.dto.BillItemDTO;
import com.biapay.core.exception.NotFoundException;
import com.biapay.core.model.Bill;
import com.biapay.core.model.BillItem;
import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantPOS;
import com.biapay.core.model.Shop;
import com.biapay.core.model.SubscriptionPlan;
import com.biapay.core.model.enums.BillStatus;
import com.biapay.core.repository.BillingRepository;
import com.biapay.core.repository.CurrencyRepository;
import com.biapay.core.repository.MerchantPOSRepository;
import com.biapay.core.repository.MerchantRepository;
import com.biapay.core.repository.ShopRepository;
import com.biapay.core.repository.SubscriptionPlanRepository;
import com.biapay.core.util.AuthUtil;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultBillingService {

  private final BillingRepository billRepository;
  private final CurrencyRepository currencyRepository;
  private final MerchantRepository merchantRepository;
  private final MerchantPOSRepository merchantPOSRepository;
  private final SubscriptionPlanRepository subscriptionPlanRepository;

  public DefaultBillingService(
      BillingRepository billRepository,
      CurrencyRepository currencyRepository,
      MerchantRepository merchantRepository,
      ShopRepository shopRepository,
      MerchantPOSRepository merchantPOSRepository,
      SubscriptionPlanRepository subscriptionPlanRepository,
      AuthUtil authUtil) {
    this.billRepository = billRepository;
    this.currencyRepository = currencyRepository;
    this.merchantRepository = merchantRepository;
    this.merchantPOSRepository = merchantPOSRepository;
    this.subscriptionPlanRepository = subscriptionPlanRepository;
  }

  public void createBillForDefaultPlan(BillForDefaultPlanDTO billDTO, HttpServletRequest request) {
    LocalDateTime invoiceDate =  LocalDateTime.now();

    log.info("Getting SuperMerchant Info");

    try {

      //    get superMerchant
      Merchant superMerchant =
          merchantRepository
              .findById(billDTO.getMerchantId())
              .orElseThrow(() -> new NotFoundException("No default POS found for Merchant!"));

      MerchantPOS superMerchantPOS =
          merchantPOSRepository
              .findDefaultPOSByMerchantId(superMerchant.getId())
              .orElseThrow(() -> new NotFoundException("No default POS found for Merchant!"));
      Shop superMerchantShop = superMerchantPOS.getShop();

      Bill bill =
          Bill.builder()
              .orderNo(billDTO.getOrderNo())
              .invoiceNo(generateInvoiceNumber())
              .invoiceDate(invoiceDate)
              .paymentDate(invoiceDate)
              .taxTotal(0.00)
              .discountTotal(0.00)
              .currency(
                  currencyRepository
                      .findById(billDTO.getCurrencyId())
                      .orElseThrow(() -> new NotFoundException("Currency not found")))
              .customer(
                  merchantRepository
                      .findById(billDTO.getCustomerId())
                      .orElseThrow(() -> new NotFoundException("Merchant not found")))
              .merchant(superMerchant)
              .shop(superMerchantShop)
              .merchantPOS(superMerchantPOS)
              .uuid(UUID.randomUUID().toString())
              .status(BillStatus.PAID)
              .paylinkId(billDTO.getPaylinkId())
              .paylinkUuid(billDTO.getPaylinkUuid())
              //            .paidAmount(billDTO.getPaidAmount())
              .build();

      Bill savedBill = billRepository.save(bill);
      AtomicReference<Double> itemTotal = new AtomicReference<>(0.00);

      BillItemDTO billItemDTO = billDTO.getPlans();

      SubscriptionPlan subscriptionPlan =
          subscriptionPlanRepository.findById(billItemDTO.getSubscriptionPlanId()).get();

      billItemDTO.setSubscriptionPlanId(billItemDTO.getSubscriptionPlanId());
      billItemDTO.setBillId(savedBill.getId());
      billItemDTO.setBillingTerms(billItemDTO.getBillingTerms());
      billItemDTO.setSubscriptionDays(subscriptionPlan.getSubscriptionDays());
      billItemDTO.setSubscriptionPlanId(billItemDTO.getSubscriptionPlanId());
      billItemDTO.setAutoRenew(billItemDTO.isAutoRenew());
      billItemDTO.setInvoicePeriod(subscriptionPlan.getInvoicePeriod());
      billItemDTO.setStartDate(invoiceDate);
      billItemDTO.setEndDate(invoiceDate.plusDays(subscriptionPlan.getSubscriptionDays()));
      billItemDTO.setPrice(subscriptionPlan.getSubscriptionAmount());
      billItemDTO.setTotalAmount(
          subscriptionPlan.getSubscriptionAmount() * billItemDTO.getBillingTerms());

      itemTotal.updateAndGet(v -> v + billItemDTO.getTotalAmount());

      List<BillItem> billItemList = new ArrayList<>();

      //    Transform from DTO to entity
      BillItem billItem = new BillItem();

      billItem.setBill(savedBill);
      billItem.setSubscriptionPlan(subscriptionPlan);
      billItem.setId(billItemDTO.getId());
      billItem.setSubscriptionDays(billItemDTO.getSubscriptionDays());
      billItem.setStartDate(billItemDTO.getStartDate());
      billItem.setEndDate(billItemDTO.getEndDate());
      billItem.setInvoicePeriod(billItemDTO.getInvoicePeriod());
      billItem.setBillingTerms(billItemDTO.getBillingTerms());
      billItem.setAutoRenew(billItemDTO.isAutoRenew());
      billItem.setPrice(billItemDTO.getPrice());
      billItem.setTotalAmount(billItemDTO.getTotalAmount());

      billItemList.add(billItem);

      savedBill.setBillingItems(billItemList);
      savedBill.setSubTotal(itemTotal.get());
      savedBill.setDiscountTotal(itemTotal.get());
      savedBill.setBillAmount(0.00);

      log.info("Completed new bill creation");
      billRepository.save(savedBill);
    } catch (Exception ex) {
      log.error("Failed to save default bill!");
    }
  }

  public Bill getDefaultBillDetailsByMerchant(Merchant merchant) {
    return billRepository.findByCustomerOrderByIdDesc(merchant);
  }

  private String generateInvoiceNumber() {
    Long lastQuotation = billRepository.count() + 1;
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyMMdd").withZone(ZoneId.systemDefault());
    String formattedInstant = formatter.format(Instant.now());
    String qtNoFormat = String.format("%05d", lastQuotation);

    return String.format("INV-%s-%s", formattedInstant, qtNoFormat);
  }
}
