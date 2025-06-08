package com.biapay.core.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "merchant_pos_subscription")
public class POSMerchantSubscription extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_pos_subscription_seq")
  @SequenceGenerator(
      name = "merchant_pos_subscription_seq",
      allocationSize = 1,
      sequenceName = "merchant_pos_subscription_seq")
  @Column(name = "merchant_subscription_id")
  private int id;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "merchant_info")
  private MerchantPOS merchantPOS;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "subscription_plan_fk")
  private SubscriptionPlan subscriptionPlanid;

  @OneToOne
  @JoinColumn(name = "subscription_payment_fk")
  private SubscriptionPayment subscriptionPaymentid;

  @Column(name = "subscription_status")
  private String subscriptionStatus;

  @Column(name = "subscription_start_date")
  private Date subscriptionStartdate;

  @Column(name = "subscription_end_date")
  private Date subscriptionEnddate;

  @Column(name = "updated_date")
  private Date updatedDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public MerchantPOS getPosMerchant() {
    return merchantPOS;
  }

  public void setPosMerchant(MerchantPOS merchantPOS) {
    this.merchantPOS = merchantPOS;
  }

  public SubscriptionPlan getSubscriptionPlanid() {
    return subscriptionPlanid;
  }

  public void setSubscriptionPlanid(SubscriptionPlan subscriptionPlanid) {
    this.subscriptionPlanid = subscriptionPlanid;
  }

  public SubscriptionPayment getSubscriptionPaymentid() {
    return subscriptionPaymentid;
  }

  public void setSubscriptionPaymentid(SubscriptionPayment subscriptionPaymentid) {
    this.subscriptionPaymentid = subscriptionPaymentid;
  }

  public String getSubscriptionStatus() {
    return subscriptionStatus;
  }

  public void setSubscriptionStatus(String subscriptionStatus) {
    this.subscriptionStatus = subscriptionStatus;
  }

  public Date getSubscriptionStartdate() {
    return subscriptionStartdate;
  }

  public void setSubscriptionStartdate(Date subscriptionStartdate) {
    this.subscriptionStartdate = subscriptionStartdate;
  }

  public Date getSubscriptionEnddate() {
    return subscriptionEnddate;
  }

  public void setSubscriptionEnddate(Date subscriptionEnddate) {
    this.subscriptionEnddate = subscriptionEnddate;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }
}
