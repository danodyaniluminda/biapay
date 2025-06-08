package com.biapay.core.model;

import com.biapay.core.model.enums.SearchUserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchUserRequest {

  private long userId;
  private String name;
  private String phone;
  private String email;
  private SearchUserType searchUserType;
}
