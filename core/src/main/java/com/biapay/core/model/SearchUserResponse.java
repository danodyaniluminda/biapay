package com.biapay.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchUserResponse {

  private long userId;
  private String name;
  private String phone;
  private String email;
  private UserType userType;
}
