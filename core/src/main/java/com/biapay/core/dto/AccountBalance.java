package com.biapay.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccountBalance {
  @JsonInclude(Include.NON_NULL)
  private Long accountId;
  private String currency;
  private BigDecimal balance;
}
