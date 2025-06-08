package com.biapay.core.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class QrCodeRequest {
  private String clientId;
  private ClientDetails clientDetails;
  private ClientUserDetails clientUserDetails;
  private OrderDetails orderDetails;
  private TransactionDetails transactionDetails;

  @Data
  @ToString
  @AllArgsConstructor
  @NoArgsConstructor
  public static class ClientDetails {
    private String originatedBy;
  }

  @Data
  @ToString
  @AllArgsConstructor
  @NoArgsConstructor
  public static class OrderDetails {
    private String orderId;
    private Double amount;
    private String currencyCode;
  }

  @Data
  @ToString
  @AllArgsConstructor
  @NoArgsConstructor
  public static class TransactionDetails {
    private String transactionId;
  }

  @Data
  @ToString
  @AllArgsConstructor
  @NoArgsConstructor
  public class ClientUserDetails {
    private String email;
    private String mobileNumber;
  }
}
