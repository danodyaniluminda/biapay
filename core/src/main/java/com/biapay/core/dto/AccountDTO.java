package com.biapay.core.dto;

import com.biapay.core.constant.enums.AccountStatus;
import com.biapay.core.model.UserType;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountDTO {

  private Long accountId;

  private String accountUserId;
  private String accountNumber;
  private UserType accountUserType;

  private String currencyCode;
  private BigDecimal balance;
  private AccountStatus accountStatus;
}
