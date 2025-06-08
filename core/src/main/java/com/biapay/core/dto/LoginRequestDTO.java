package com.biapay.core.dto;

import com.biapay.core.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDTO {
  private String email;
  private String password;
  private UserType userType;
}
