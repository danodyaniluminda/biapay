package com.biapay.core.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;

@Data
public class DailySummaryDto {
  private LocalDate transactionDate;
  private BigDecimal totalAmount;

  public DailySummaryDto(LocalDate transactionDate, BigDecimal totalAmount) {
    this.transactionDate = transactionDate;
    this.totalAmount = totalAmount;
  }
}
