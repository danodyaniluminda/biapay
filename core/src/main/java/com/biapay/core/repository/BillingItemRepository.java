package com.biapay.core.repository;

import com.biapay.core.model.Bill;
import com.biapay.core.model.BillItem;
import com.biapay.core.model.Merchant;
import com.biapay.core.model.SubscriptionPlan;
import com.biapay.core.model.enums.BillStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillingItemRepository extends JpaRepository<BillItem, Long> {

  List<BillItem> findAllBySubscriptionPlan(SubscriptionPlan plan);

  @Query(
      "select bt from BillItem bt join Bill b on b.id = bt.bill.id where bt.subscriptionPlan=:plan and b.customer=:customer ")
  Optional<BillItem> findAllBySubscriptionPlanAndCustomer(SubscriptionPlan plan, Merchant customer);

  List<BillItem> findAllByBill(Bill bill);

  @Query("from BillItem bt left join Bill b on b.id = bt.bill.id where b.status=:status")
  List<BillItem> findAllByBillStatus(BillStatus status);

  @Query(
      "select bt from BillItem bt join Bill b on b.id = bt.bill.id where bt.subscriptionPlan=:plan and b.customer=:customer and b.status=:status")
  List<BillItem> findAllBySubscriptionPlanAndCustomerAndStatus(SubscriptionPlan plan, Merchant customer, BillStatus status);

  long countByStartDate(LocalDateTime startDate);

  @Query(
      "select bt from BillItem bt join Bill b on b.id = bt.bill.id where bt.subscriptionPlan=:plan and b.customer=:customer order by b.invoiceDate asc")
  Optional<BillItem> findFirstBySubscriptionPlanAndCustomer(SubscriptionPlan plan, Merchant customer);

  @Query(
      "select bt from BillItem bt join Bill b on b.id = bt.bill.id where bt.subscriptionPlan=:plan and b.customer=:customer order by b.invoiceDate desc" )
  Optional<BillItem> findLastBySubscriptionPlanAndCustomer(SubscriptionPlan plan, Merchant customer);

  @Query(
      "select bt from BillItem bt join Bill b on b.id = bt.bill.id where bt.subscriptionPlan=:plan and b.customer=:customer order by b.invoiceDate desc" )
  List<BillItem> getAllBySubscriptionPlanAndCustomer(SubscriptionPlan plan, Merchant customer);
}
