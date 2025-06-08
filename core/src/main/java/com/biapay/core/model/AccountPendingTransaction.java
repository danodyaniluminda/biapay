package com.biapay.core.model;

import com.biapay.core.constant.enums.AccountTransactionStatus;
import com.biapay.core.model.enums.AccountEventType;
import com.biapay.core.model.enums.AccountTransactionType;
import com.biapay.core.model.enums.AccountType;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_pending_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountPendingTransaction extends AbstractAuditingEntity {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "account_pending_transactions_id_seq")
  @SequenceGenerator(
      name = "account_pending_transactions_id_seq",
      allocationSize = 1,
      sequenceName = "account_pending_transactions_id_seq")
  private Long id;

  private UUID transactionId;
  private String uniqueRef;

  @Column(name = "init_user_id")
  private Long initUserId;

  @Enumerated(EnumType.STRING)
  @Column(name = "init_user_type")
  private UserType initUserType;

  private Long sourceUserId;
  @Enumerated(EnumType.STRING)
  private AccountType sourceAccountType;
  @Enumerated(EnumType.STRING)
  private AccountEventType sourceAccountEvent;

  private Long receiverUserId;
  @Enumerated(EnumType.STRING)
  private AccountType receiverAccountType;
  @Enumerated(EnumType.STRING)
  private AccountEventType receiverAccountEvent;

  private String currencyCode;

  private BigDecimal amount;
  private BigDecimal fees;
  private BigDecimal tax;
  private BigDecimal operationFees;
  private BigDecimal transactionFees;
  private BigDecimal otherFees;

  private String transactionSource;

  @Enumerated(EnumType.STRING)
  private AccountTransactionType transactionType;

  @Enumerated(EnumType.STRING)
  private AccountTransactionStatus transactionStatus;

  private String reference;
  private String narration;
  private String remarks;

  private Boolean isProcessed;

  private LocalDate transactionDate;
  private LocalDate processDate;

  private String createdBy;
  private Instant createdDate;
  private String lastModifiedBy;
  private Instant lastModifiedDate;
}
