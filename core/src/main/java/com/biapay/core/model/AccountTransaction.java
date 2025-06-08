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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountTransaction extends AbstractAuditingEntity {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "account_transaction_account_transaction_id_seq")
  @SequenceGenerator(
      name = "account_transaction_account_transaction_id_seq",
      allocationSize = 1,
      sequenceName = "account_transaction_account_transaction_id_seq")
  private Long id;

  @Column(name = "unique_ref", nullable = false, length = 50)
  private String uniqueRef;

  private UUID transactionRef;

  @Column(name = "init_user_id")
  private Long initUserId;

  @Enumerated(EnumType.STRING)
  @Column(name = "init_user_type")
  private UserType initUserType;

  @ManyToOne
  @JoinColumn(name = "source_account_id")
  private Account sourceAccount;
  private Long sourceUserId;
  @Column(name = "source_user_name")
  private String sourceUsername;
  private String sourceMobileNumber;
  @Enumerated(EnumType.STRING)
  private UserType sourceUserType;
  @Enumerated(EnumType.STRING)
  private AccountType sourceAccountType;
  @Enumerated(EnumType.STRING)
  private AccountEventType sourceAccountEvent;
  private BigDecimal sourceAccountBalanceBefore;
  private BigDecimal sourceAccountBalance;

  @ManyToOne
  @JoinColumn(name = "receiver_account_id")
  private Account receiverAccount;
  private Long receiverUserId;
  @Column(name = "receiver_user_name")
  private String receiverUsername;
  private String receiverMobileNumber;
  @Enumerated(EnumType.STRING)
  private UserType receiverUserType;
  @Enumerated(EnumType.STRING)
  private AccountType receiverAccountType;
  @Enumerated(EnumType.STRING)
  private AccountEventType receiverAccountEvent;
  private BigDecimal receiverAccountBalanceBefore;
  private BigDecimal receiverAccountBalance;

  private String currencyCode;
  private BigDecimal amount;
  private BigDecimal transactionAmount;
  private BigDecimal fees;
  private BigDecimal operationFees;
  private BigDecimal transactionFees;
  private BigDecimal otherFees;
  private BigDecimal tax;

  private String transactionSource;
  @Enumerated(EnumType.STRING)
  private AccountTransactionType transactionType;
  @Enumerated(EnumType.STRING)
  private AccountTransactionStatus transactionStatus;

  private String narration;
  private String remarks;
  private String remarks2;

  private LocalDate transactionDate;
  private LocalDate processDate;
  private Boolean isProcessed;

  private String createdBy;
  private Instant createdDate;
  private String lastModifiedBy;
  private Instant lastModifiedDate;
}
