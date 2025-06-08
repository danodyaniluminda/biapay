package com.biapay.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltySettlementRequest implements Serializable {

  private UUID clientTransactionId;
  private long merchantPOSId;
  private BigDecimal amount;
  private String currency;
  private String settlementPeriodName;
  private long paymentMethodId;
}
