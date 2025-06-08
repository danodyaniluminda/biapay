package com.biapay.core.dto;

import com.biapay.core.constant.enums.AccountTransactionStatus;
import com.biapay.core.model.UserType;
import com.biapay.core.model.enums.AccountEventType;
import com.biapay.core.model.enums.AccountTransactionType;
import com.biapay.core.model.enums.AccountType;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountPendingTransactionDTO {

  private Long transaction_id;
  private Long initUserId;

  @Enumerated(EnumType.STRING)
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
  private BigDecimal commission = BigDecimal.ZERO;

  private String transactionSource;

  @Enumerated(EnumType.STRING)
  private AccountTransactionType transactionType;

  private String reference;
  private String narration;
  private String remarks;

  @Enumerated(EnumType.STRING)
  private AccountTransactionStatus transactionStatus;

  private Boolean isProcessed;

  private LocalDate transactionDate;
  private LocalDate processDate;

  private String createdBy;
  private Instant createdDate;
  private String lastModifiedBy;
  private Instant lastModifiedDate;
}
