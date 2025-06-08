package com.biapay.core.dto;

import com.biapay.core.constant.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPlanDTO {
  private Long id;
  private String subscriptionName;
  private BigDecimal subscriptionAmount;
  private Integer subscriptionDays;
  private Boolean subscriptionStatus;
  private ChannelType typeofChannels;
  private Integer numberofTransaction;
  private SettlementPeriod settlementPeriod;
  private InvoicePeriod invoicePeriod;
  @NotNull @NotEmpty private PaymentMethodDTO[] paymentMethodsSet;
  private PaymentType typeofPayment;
  private boolean shoppingcardAllowance;
  private boolean ancillariesAllowance;
  private boolean paymaillinkRequest;
  private boolean downgradeAllowable;
  private boolean invoicePayment;
  private boolean eventManagement;
  private boolean shoppingCart;
  private boolean defaultPlan;
  private boolean featured;
  private boolean flag;
  private IntegrationType typeofIntegration;
  private BigDecimal setupFee;
  private BigDecimal minimumUsefee;
  private BigDecimal statementFee;
  private BigDecimal discountRatefee;
  private BigDecimal addonModulesFee;
  private BigDecimal gatewayFee;
  private BigDecimal batchFee;
  private CurrencyDTO[] currencies;
  private SubscriptionPlanType planType;
  private TransactionFeePayer transactionFeePayer;
  private Integer maxSubUsers;
  private Integer maxShops;
  private Integer maxPOSPerShop;
  private Integer maxListedProducts;
  private Integer maxPublishedEvents;
  private List<TransactionLimitDTO> transactionLimits;
  private boolean enableSplitSettlement;
  private boolean rolesManagement;
  private boolean settlement;
  private boolean accessHistory;
  private boolean shopManagement;
  private boolean dashboard;
  private boolean transactions;
  private boolean loyalty;
  private boolean referral;
  private boolean testPlan;
  private BigDecimal merchantFeePercentage;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class PaymentMethodDTO {
    @NotNull private Long id;
    private String name;
    private Boolean status;
    private boolean isChecked;
    private PaymentCategoryDTO paymentCategory;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class PaymentCategoryDTO {
    private Long id;
    private String name;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class CurrencyDTO {
    private Long id;
    private String name;
    private String symbol;
    private String code;
    private String status;
  }
}
