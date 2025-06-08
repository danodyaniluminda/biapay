package com.biapay.core.model.user;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.model.CustomerData;
import com.biapay.core.model.IdentityInformation;
import com.biapay.core.model.enums.Gender;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_kyc")
public class UserKYC {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_kyc_seq")
  @SequenceGenerator(name = "user_kyc_seq", allocationSize = 1, sequenceName = "user_kyc_seq")
  @Column(name = "id")
  private Long id;

  @Column(name = "client")
  private String client;

  @Column(name = "name")
  private String name;

  @Column(name = "dateofbirth")
  private String dateofbirth;

  @Column(name = "emailid")
  private String emailid;

  @Column(name = "mobileno")
  private String mobileno;

  @Column(name = "addressone")
  private String addressone;

  @Column(name = "addresstwo")
  private String addresstwo;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "country")
  private String country;

  @Column(name = "zipcode")
  private int zipcode;

  @Column(name = "longitude")
  private float longitude;

  @Column(name = "latitude")
  private float latitude;

  @Column(name = "taxpayernumber")
  private String taxpayernumber;

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @OneToOne
  @JoinColumn(name = "customer_data_id")
  private CustomerData customerData;

  @OneToOne
  @JoinColumn(name = "identityInformation")
  private IdentityInformation identityInformation;

  @Enumerated(EnumType.STRING)
  private KycApprovalStatus kycApprovalStatus;
}
