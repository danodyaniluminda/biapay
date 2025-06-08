package com.biapay.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReferredUsers {

  private Long userId;
  private String name;
  private String mobileNumber;
  private String email;
  private UserType userType;
  private int points;
  private String referralCode;
}
