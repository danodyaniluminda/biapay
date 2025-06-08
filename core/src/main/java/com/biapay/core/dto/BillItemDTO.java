package com.biapay.core.dto;

import com.biapay.core.constant.enums.InvoicePeriod;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillItemDTO {

  private Long id;

  private Long billId;

  private Long subscriptionPlanId;
  private String subscriptionPlanName;

  private int subscriptionDays;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime startDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime endDate;

  private InvoicePeriod invoicePeriod;

  private int billingTerms;

  private boolean autoRenew;

  private Double price;

  private Double totalAmount;
}
