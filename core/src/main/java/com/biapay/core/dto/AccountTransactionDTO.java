package com.biapay.core.dto;

import com.biapay.core.constant.enums.AccountTransactionStatus;
import com.biapay.core.model.Account;
import com.biapay.core.model.AccountPendingTransaction;
import com.biapay.core.model.User;
import com.biapay.core.model.UserType;
import com.biapay.core.model.enums.AccountEventType;
import com.biapay.core.model.enums.AccountTransactionType;
import com.biapay.core.model.enums.AccountType;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountTransactionDTO {
  private Long id;
  private String uniqueRef;
  private UUID transactionRef;
  private Long initUserId;

  @Enumerated(EnumType.STRING)
  private UserType initUserType;

  private Account sourceAccount;
  private Long sourceUserId;
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

  private Account receiverAccount;
  private Long receiverUserId;
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
