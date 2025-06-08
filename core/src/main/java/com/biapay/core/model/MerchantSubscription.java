package com.biapay.core.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "merchant_subscription")
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MerchantSubscription extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_subscription_seq")
  @SequenceGenerator(
      name = "merchant_subscription_seq",
      allocationSize = 1,
      sequenceName = "merchant_subscription_seq")
  @Column(name = "merchant_subscription_id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "merchant_id")
  @ToString.Exclude
  private Merchant merchant;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "subscription_plan_id")
  @ToString.Exclude
  private SubscriptionPlan subscriptionPlan;

  @OneToOne
  @JoinColumn(name = "subscription_payment_id")
  private SubscriptionPayment subscriptionPayment;

  @Column(name = "subscription_status")
  private String subscriptionStatus;

  @Column(name = "subscription_start_date")
  private Date subscriptionStartDate;

  @Column(name = "subscription_end_date")
  private Date subscriptionEndDate;

  @Column(name = "updated_date")
  private Date updatedDate;


  private String subscriptionDisplayName;

  @OneToOne
  @JoinColumn(name = "merchant_pos_id")
  private MerchantPOS merchantPOS;

  @OneToMany(mappedBy = "merchantSubscription", cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<MerchantSubscriptionHistory> merchantSubscriptionHistories;

  @Transient private String subscriptionPlanName;

  @Transient private String merchantName;

  @Transient private String startDate;

  @Transient private String endDate;
}
