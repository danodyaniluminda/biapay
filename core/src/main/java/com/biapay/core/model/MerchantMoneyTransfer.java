package com.biapay.core.model;

import com.biapay.core.constant.ClientTransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "merchant_money_transfers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class MerchantMoneyTransfer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "ref")
  private UUID ref;

  @Column(name = "transaction_ref")
  private String transactionRef;

  @Column(name = "sender_merchant_id")
  private Long senderMerchantId;

  @Column(name = "sender_merchant_account")
  private Long senderMerchantAccount;

  @Column(name = "receiver_merchant_id")
  private Long receiverMerchantId;

  @Column(name = "receiver_merchant_account")
  private Long receiverMerchantAccount;

  @Column(name = "currency")
  private String currency;

  @Column(name = "initial_amount")
  private BigDecimal initialAmount;

  @Column(name = "operation_fees")
  private BigDecimal operationFees;

  @Column(name = "transaction_tees")
  private BigDecimal transactionFees;

  @Column(name = "tax")
  private BigDecimal tax;

  @Column(name = "total_amount")
  private BigDecimal totalAmount;

  @Enumerated(EnumType.STRING)
  private ClientTransactionStatus status;

  @Column(name = "transaction_date")
  private LocalDate transactionDate;

  @Column(name = "initiated_by")
  private String initiatedBy;

  @Column(name = "initiated_at")
  private LocalDateTime initiatedAt;

  @Column(name = "approved_by")
  private String approvedBy;

  @Column(name = "approved_at")
  private LocalDateTime approvedAt;

  @Column(name = "completed_at")
  private LocalDateTime completedAt;

  @Column(name = "failed_at")
  private LocalDateTime failedAt;
}
