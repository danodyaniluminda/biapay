package com.biapay.core.dto;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.model.BusinessDetails;
import com.biapay.core.model.IdentityInformation;
import com.biapay.core.model.Merchant;
import com.biapay.core.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KYCFormDto {
  private Long id;
  private String client;
  private String name;
  private String dateofbirth;
  private String emailid;
  private String mobileno;
  private String addressone;
  private String addresstwo;
  private String city;
  private String state;
  private String country;
  private int zipcode;
  private float longitude;
  private float latitude;
  private Gender gender;
  private Merchant merchant;
  private IdentityInformation identityInformation;
  private BusinessDetails businessdetails;
  private KycApprovalStatus kycApprovalStatus;
  private String sector;
}
