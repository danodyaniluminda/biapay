package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "transaction_limit_management")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class TransactionLimitManagement {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "sending_daily")
  private BigDecimal sendingDaily;

  @Column(name = "sending_weekly")
  private BigDecimal sendingWeekly;

  @Column(name = "sending_monthly")
  private BigDecimal sendingMonthly;

  @Column(name = "receiving_daily")
  private BigDecimal receivingDaily;

  @Column(name = "receiving_weekly")
  private BigDecimal receivingWeekly;

  @Column(name = "receiving_monthly")
  private BigDecimal receivingMonthly;

  @Column(name = "user_type")
  @Enumerated(EnumType.STRING)
  private UserType userType;

  @Column(name = "user_status")
  @Enumerated(EnumType.STRING)
  private UserStatus userStatus;

  @ManyToOne
  @JoinColumn(name = "currency_id")
  private Currency currency;

  @ManyToOne
  @JoinColumn(name = "subscription_plan_id")
  private SubscriptionPlan subscriptionPlan;
}
