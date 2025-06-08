package com.biapay.core.dto;

import com.biapay.core.model.enums.BillStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BillResponseDTO {

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

  private Double subTotal;

  private Double taxTotal;

  private Double discountTotal;

  private Double billAmount;

  private Double paidAmount;

  private Long currencyId;

  private String currencyCode;

  private Long customerId;

  private CustomerDTO customerDTO;

  private Long shopId;

  private String shopName;

  private Long merchantPOSId;

  private String merchantPOSName;

  private Long merchantId;

  private String merchantName;

  private List<BillItemDTO> billingItems;

  private BillStatus status;

  private Long paylinkId;

  private String paylinkUuid;

  private List<SubscriptionPlanDTO> plans;
}
