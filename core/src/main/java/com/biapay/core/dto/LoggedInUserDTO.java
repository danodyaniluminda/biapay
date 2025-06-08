package com.biapay.core.dto;

import com.biapay.core.model.User;
import com.biapay.core.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoggedInUserDTO {
  private String email;
  private String sub;
  private UserType userType;
  private Long userId;
  private LoggedInUserDTO impersonator;
  private User user;
}
