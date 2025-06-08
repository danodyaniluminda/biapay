package com.biapay.core.dto;

import com.biapay.core.model.enums.AccountEventType;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountEventDTO {

  private Long accountEventId;

  private AccountDTO account;

  private AccountTransactionDTO accountTransaction;

  private BigDecimal balanceBeforeTransaction;

  private AccountEventType eventType;
}
