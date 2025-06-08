package com.biapay.core.model.response;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class APIErrorResponse {

  private long timestamp;
  private int status;
  private String error;
  private String message;
  private String path;
}
