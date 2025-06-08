package com.biapay.core.model;

import com.biapay.core.model.enums.PaymentStatus;
import com.biapay.core.model.enums.PlanPurchaseStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "subscription_payment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubscriptionPayment extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscription_payment_seq")
  @SequenceGenerator(
      name = "subscription_payment_seq",
      allocationSize = 1,
      sequenceName = "subscription_payment_seq")
  @Column(name = "subscription_payment_id")
  private int id;

  @Column(name = "subscription_amount")
  private Double subscriptionAmount;

  // newly added columns
  @Column(name="pay_link_id")
   private Long payLinkId;

  @Column(name="client_transaction_id")
  private UUID clientTransactionId;

  @Column(name="payment_status")
  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;

  @Column(name="merchant_subscription_id")
  private Long merchantSubscriptionId;

  @Column(name = "plan_purchase_status")
  @Enumerated(EnumType.STRING)
  private PlanPurchaseStatus planPurchaseStatus;
  // newly added columns

  public Long getPayLinkId() {
    return payLinkId;
  }

  public void setPayLinkId(Long payLinkId) {
    this.payLinkId = payLinkId;
  }

  public UUID getClientTransactionId() {
    return clientTransactionId;
  }

  public void setClientTransactionId(UUID clientTransactionId) {
    this.clientTransactionId = clientTransactionId;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public Long getMerchantSubscriptionId() {
    return merchantSubscriptionId;
  }

  public void setMerchantSubscriptionId(Long merchantSubscriptionId) {
    this.merchantSubscriptionId = merchantSubscriptionId;
  }

  public PlanPurchaseStatus getPlanPurchaseStatus() {
    return planPurchaseStatus;
  }

  public void setPlanPurchaseStatus(PlanPurchaseStatus planPurchaseStatus) {
    this.planPurchaseStatus = planPurchaseStatus;
  }



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Double getSubscriptionAmount() {
    return subscriptionAmount;
  }

  public void setSubscriptionAmount(Double subscriptionAmount) {
    this.subscriptionAmount = subscriptionAmount;
  }
}
