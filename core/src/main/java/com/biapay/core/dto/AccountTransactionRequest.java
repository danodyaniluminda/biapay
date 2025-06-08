package com.biapay.core.dto;

import com.biapay.core.constant.enums.AccountTransactionStatus;
import com.biapay.core.model.UserType;
import com.biapay.core.model.enums.AccountEventType;
import com.biapay.core.model.enums.AccountTransactionType;
import com.biapay.core.model.enums.AccountType;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountTransactionRequest {
  private Long transactionId;
  private Long initUserId;
  private UserType initUserType;

  private Long sourceUserId;
  private Long sourceAccountId;
  private UserType sourceUserType;
  private AccountType sourceAccountType;
  private AccountEventType sourceAccountEventType;
  private AccountTransactionType sourceAccountTransactionType;

  private Long receiverUserId;
  private Long receiverAccountUserId;
  private UserType receiverUserType;
  private AccountType receiverAccountType;
  private AccountEventType receiverAccountEventType;
  private AccountTransactionType receiverAccountTransactionType;

  private AccountTransactionType transactionType;

  private BigDecimal amount;
  private BigDecimal planAutoRenewAmount;
  private BigDecimal fee;
  private BigDecimal transactionFees;
  private BigDecimal operationFees;
  private BigDecimal tax;
  private BigDecimal otherFees;

  private String transactionSource;
  private String reference;
  private String narration;
  private String remarks;
  private AccountTransactionStatus status;
  private Boolean isProcessed;
  private LocalDate transactionDate;
  private LocalDate processDate;
  private Instant createdDate;
  private String currencyCode;
}
