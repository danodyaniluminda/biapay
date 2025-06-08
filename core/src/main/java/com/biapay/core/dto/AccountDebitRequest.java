package com.biapay.core.dto;

import com.biapay.core.model.UserType;
import com.biapay.core.model.enums.AccountEventType;
import com.biapay.core.model.enums.AccountTransactionType;
import com.biapay.core.model.enums.AccountType;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountDebitRequest {
  private Long debitAccountUserId;
  private UserType debitAccountUserType;
  private AccountType debitAccountType;

  private AccountTransactionType transactionType;
  private BigDecimal amount;
  private BigDecimal fee;
  private BigDecimal tax;
  private String transactionReference;
  private String transactionDescription;
  private String remarks;
  private Instant createdDate;
  private String currencyCode;
}
