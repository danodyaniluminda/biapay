package com.biapay.core.dto.authenticator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTwoMFAStatusDTO {

  private boolean enable;
  private String userId;
  private Integer userDeviceId;
}
