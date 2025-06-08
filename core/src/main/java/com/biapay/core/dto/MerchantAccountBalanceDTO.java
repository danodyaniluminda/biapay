package com.biapay.core.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class MerchantAccountBalanceDTO extends AccountBalance {
  private BigDecimal available;
  private BigDecimal onHold;
}
