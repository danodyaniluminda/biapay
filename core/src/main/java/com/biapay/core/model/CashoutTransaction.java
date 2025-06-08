package com.biapay.core.model;

import com.biapay.core.model.enums.CashoutChannel;
import com.biapay.core.model.enums.CashoutStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cashout_transaction")
@Getter
@Setter
@ToString
public class CashoutTransaction {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "to_service")
  private PayoutService toService;

  @ManyToOne
  @JoinColumn(name = "from_service")
  private PayoutService fromService;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "fee")
  private BigDecimal fee;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private CashoutStatus status;

  @Column(name = "currency")
  private String currency;

  @Column(name = "merchant_id")
  private Long merchantId;

  @Column(name = "recipient_account_id")
  private Long recipientAccountId;

  @Column(name = "recipient_id")
  private Long recipientId;

  @Column(name = "recipient_account")
  private String recipientAccount;

  @Column(name = "message")
  private String message;

  @Column(name = "note")
  private String note;

  @Column(name = "cashout_channel")
  @Enumerated(EnumType.STRING)
  private CashoutChannel cashoutChannel;

  @Column(name = "initiated_at")
  private LocalDateTime initiatedAt;

  @Column(name = "initiated_by")
  private String initiatedBy;

  @Column(name = "processed_at")
  private LocalDateTime processedAt;

  @Column(name = "processed_by")
  private String processedBy;

  @Column(name = "completed_at")
  private LocalDateTime completedAt;

  @Column(name = "completed_by")
  private String completedBy;

  @Column(name = "cashout_transaction_id")
  private UUID cashoutTransactionId;

  @Column(name = "settlement_method_id")
  private Long settlementMethodId;
}
