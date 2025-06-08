package com.biapay.core.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TransactionLimitDTO {
  private Long id;
  private BigDecimal sendingDaily;
  private BigDecimal sendingWeekly;
  private BigDecimal sendingMonthly;
  private BigDecimal receivingDaily;
  private BigDecimal receivingWeekly;
  private BigDecimal receivingMonthly;

  private Long currencyId;
  private Long subscriptionPlanId;
}
