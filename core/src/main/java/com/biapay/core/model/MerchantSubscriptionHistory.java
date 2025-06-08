package com.biapay.core.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "merchant_subscription_history")
@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MerchantSubscriptionHistory extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "merchant_subscription_id")
  private MerchantSubscription merchantSubscription;

  @ManyToOne
  @JoinColumn(name = "merchant_id")
  private Merchant merchant;

  @OneToOne
  @JoinColumn(name = "merchant_pos_id")
  private MerchantPOS merchantPOS;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "subscription_plan_id")
  private SubscriptionPlan subscriptionPlan;

  @OneToOne
  @JoinColumn(name = "subscription_payment_id")
  private SubscriptionPayment subscriptionPayment;

  @Column(name = "subscription_start_date")
  private Date subscriptionStartDate;

  @Column(name = "subscription_end_date")
  private Date subscriptionEndDate;

  @Column(name = "subscription_terminated_date")
  private Date subscriptionTerminatedDate;
}
