package com.biapay.core.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TwoFactorAuthenticationResponse {

  private String error;
  private String message;
  private String path;
  private int status;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Timestamp timestamp;

  private String otpAuthCode;
}
