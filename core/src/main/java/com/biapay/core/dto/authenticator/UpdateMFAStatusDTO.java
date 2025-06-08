package com.biapay.core.dto.authenticator;

import com.biapay.core.model.MFAStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMFAStatusDTO {

  private MFAStatus status;
  private String userId;
  private String userDeviceId;
}
