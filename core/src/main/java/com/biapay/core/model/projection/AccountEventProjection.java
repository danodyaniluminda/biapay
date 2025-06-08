package com.biapay.core.model.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface AccountEventProjection {
  LocalDate getTransactionDate();
  String getTransactionRef(); // UUID as String
  String getEventType();      // Enum as String
  String getCurrencyCode();
  BigDecimal getAmount();
  BigDecimal getBalanceBeforeTransaction();
  BigDecimal getBalanceAfterTransaction();
  String getTransactionType(); // Enum as String
  String getTransactionSource();
}
