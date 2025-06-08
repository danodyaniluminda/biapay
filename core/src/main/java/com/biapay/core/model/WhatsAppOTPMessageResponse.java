package com.biapay.core.model;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WhatsAppOTPMessageResponse {
  public String messaging_product;
  public ArrayList<Contact> contacts;
  public ArrayList<Message> messages;
  public Error error;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Contact {
    public String input;
    public String wa_id;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Message {
    public String id;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Error {
    public String message;
    public String type;
    public int code;
    public ErrorData error_data;
    public String fbtrace_id;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ErrorData {
    public String messaging_product;
    public String details;
  }
}
