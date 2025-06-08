package com.biapay.core.dto;

import com.biapay.core.model.enums.BillStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BillForDefaultPlanDTO {

  private Long id;

  private String uuid;

  private String invoiceNo;

  private String orderNo;

  private String description;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime invoiceDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime paymentDate;

  private Long currencyId;

  private String currencyCode;

  private Long merchantId;

  private Long customerId;

  private CustomerDTO customerDTO;

  private BillItemDTO plans;

  private BillStatus status;

  private Long paylinkId;

  private String paylinkUuid;
}
