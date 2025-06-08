package com.biapay.core.model;

import com.biapay.core.model.enums.TransactionIdType;
import com.biapay.core.model.enums.UserTransactionLimitStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_transaction_limit")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class UserTransactionLimit {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @ToString.Exclude
  private User user;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "is_sending")
    private boolean isSending;

    @Column(name = "current_sending_daily")
  private BigDecimal currentSendingDaily;

  @Column(name = "current_sending_weekly")
  private BigDecimal currentSendingWeekly;

  @Column(name = "current_sending_monthly")
  private BigDecimal currentSendingMonthly;

  @Column(name = "current_receiving_daily")
  private BigDecimal currentReceivingDaily;

  @Column(name = "current_receiving_weekly")
  private BigDecimal currentReceivingWeekly;

  @Column(name = "current_receiving_monthly")
  private BigDecimal currentReceivingMonthly;

  @ManyToOne
  @JoinColumn(name = "transaction_limit_management_id")
  private TransactionLimitManagement transactionLimitManagement;

  @ManyToOne
  @JoinColumn(name = "user_transaction_limit_management_id")
  private UserTransactionLimitManagement userTransactionLimitManagement;

  @Column(name = "transaction_id")
  private String transactionId;

  @Column(name = "transaction_id_type")
  @Enumerated(EnumType.STRING)
  private TransactionIdType transactionIdType;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private UserTransactionLimitStatus status;

  @Column(name = "created_at")
  private Timestamp createdAt;
}
