package com.biapay.core.model;

import com.biapay.core.constant.InvoiceType;
import com.biapay.core.model.enums.UserLoyaltyActivityType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class LoyaltyBillDTO implements Serializable {
  private String uuid;
  private String orderNo;
  private String invoiceNo;
  private LocalDateTime invoiceDate;
  private BigDecimal amount;
  private UserLoyaltyActivityDTO userLoyaltyActivities;
  private PayLinkDTO paylink;
  private String paylinkUuid;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @ToString
  @Builder(toBuilder = true)
  public static class UserLoyaltyActivityDTO implements Serializable {
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
    private Long id;
    private Long senderUserId;
    private Integer points;
    private String recipientFirstName;
    private String recipientLastName;
    private String recipientPhoneNo;
    private String recipientEmail;
    private String personalMessage;
    private UserLoyaltyActivityType activityType;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @ToString
  @Builder(toBuilder = true)
  public static class PayLinkDTO implements Serializable {
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
    private Long id;
    private UUID uuid;
    private String mobileNumber;
    private String customerName;
    private String email;
    private BigDecimal amount;
    private String currency;
    private String message;
    private PayLinkStatus status;
    private InvoiceType invoiceType;
  }
}
