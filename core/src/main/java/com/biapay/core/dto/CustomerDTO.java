package com.biapay.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
  private Long id;

  private String firstName;
  private String lastName;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String postcode;
  private String country;

  private String email;

  private String phoneNumber;

  private String reference;

  private String website;

  private Double taxRate;

  private Long currencyId;

  private Long merchantId;

  private String action;
}
