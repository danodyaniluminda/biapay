package com.biapay.core.model;

import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "referral_reward_check_task")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReferralRewardCheckTask extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referral_reward_check_task_seq")
  @SequenceGenerator(
      name = "referral_reward_check_task_seq",
      allocationSize = 1,
      sequenceName = "referral_reward_check_task_seq")
  @Column(name = "id")
  private Long id;

  @Column(name = "client_business_id")
  private String clientBusinessID;

  @Column(name = "client_transaction_id")
  private UUID clientTransactionId;

  @Column(name = "transaction_direction")
  @Enumerated(EnumType.STRING)
  private TransactionDirection transactionDirection;

  @Column(name = "user_id")
  private Long userId;
}
