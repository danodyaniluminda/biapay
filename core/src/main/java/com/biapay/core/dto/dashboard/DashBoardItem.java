package com.biapay.core.dto.dashboard;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DashBoardItem {
  protected String currency;
  protected BigDecimal total;
  protected long counter;
  List<DashBoardItemValue> dashBoardItemValues;

  public DashBoardItem(String currency, BigDecimal total, long counter) {
    this.currency = currency;
    this.total = total;
    this.counter = counter;
  }

  public void increaseCounter() {
    counter++;
  }

  public void increaseCounter(long increment) {
    counter += increment;
  }
}
