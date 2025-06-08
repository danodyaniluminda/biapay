package com.biapay.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferralDTO implements Serializable {
  private BigDecimal minAmount;
  private Long currencyId;
  private int reward;
  private boolean active;
}
