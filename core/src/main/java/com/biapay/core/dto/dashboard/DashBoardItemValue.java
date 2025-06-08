package com.biapay.core.dto.dashboard;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
public class DashBoardItemValue {
  private long keyId;
  private String keyName;
  private BigDecimal totalValue;
  private long itemCount;

  public DashBoardItemValue(long keyId, String keyName, BigDecimal totalValue, long itemCount) {
    this.keyId = keyId;
    this.keyName = keyName;
    this.totalValue = totalValue;
    this.itemCount = itemCount;
  }
}
