package com.biapay.core.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trial_subscription")
public class TrialSubscription extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trial_subscription_seq")
  @SequenceGenerator(
      name = "trial_subscription_seq",
      allocationSize = 1,
      sequenceName = "trial_subscription_seq")
  @Column(name = "merchant_subscription_id")
  private int id;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "merchant_info")
  private Merchant merchant;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "subscription_plan_fk")
  private SubscriptionPlan subscriptionPlanid;

  @Column(name = "subscription_status")
  private String subscriptionStatus;

  @Column(name = "subscription_start_date")
  private Date subscriptionStartdate;

  @Column(name = "subscription_end_date")
  private Date subscriptionEnddate;

  @Transient private String subscriptionPlanName;

  @Transient private String merchantName;

  @Transient private String startDate;

  @Transient private String endDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Merchant getMerchant() {
    return merchant;
  }

  public void setMerchant(Merchant merchant) {
    this.merchant = merchant;
  }

  public SubscriptionPlan getSubscriptionPlanid() {
    return subscriptionPlanid;
  }

  public void setSubscriptionPlanid(SubscriptionPlan subscriptionPlanid) {
    this.subscriptionPlanid = subscriptionPlanid;
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

  public String getSubscriptionPlanName() {
    return subscriptionPlanName;
  }

  public void setSubscriptionPlanName(String subscriptionPlanName) {
    this.subscriptionPlanName = subscriptionPlanName;
  }

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
}
