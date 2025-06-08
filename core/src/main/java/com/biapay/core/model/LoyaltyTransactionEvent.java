package com.biapay.core.model;

import com.biapay.core.model.enums.EventCalculationOperator;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.*;
import lombok.*;

@Table(name = "loyalty_transaction_events")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyTransactionEvent extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "subscription_plan_id")
  private long subscriptionPlanId = 0;

  @Column(name = "no_of_transactions_from")
  private int noOfTransactionsFrom;

  @Column(name = "no_of_transactions_to")
  private int noOfTransactionsTo;

  @Column(name = "amount_from")
  private BigDecimal amountFrom;

  @Column(name = "amount_to")
  private BigDecimal amountTo;

  @Column(name = "sum_of_sending_amount_from")
  private BigDecimal sumOfSendingAmountFrom;

  @Column(name = "sum_of_sending_amount_to")
  private BigDecimal sumOfSendingAmountTo;

  @Column(name = "sum_of_receiving_amount_from")
  private BigDecimal sumOfReceivingAmountFrom;

  @Column(name = "sum_of_receiving_amount_to")
  private BigDecimal sumOfReceivingAmountTo;

  @Column(name = "reach_goal_from")
  private Timestamp reachGoalFrom;

  @Column(name = "reach_goal_to")
  private Timestamp reachGoalTo;

  @Column(name = "no_time_limit")
  private boolean noTimeLimit;

  @Column(name = "calc_operator")
  @Enumerated(EnumType.STRING)
  private EventCalculationOperator calcOperator;
}
