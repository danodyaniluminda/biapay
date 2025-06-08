package com.biapay.core.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirebaseRegistrationTokenRequest {
  private String registrationToken;
  private boolean register = true;
}
