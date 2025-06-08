package com.biapay.core.model;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.constant.enums.MerchantStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "merchant")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
public class Merchant extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_seq")
  @SequenceGenerator(name = "merchant_seq", allocationSize = 1, sequenceName = "merchant_seq")
  private Long id;

  @Column(name = "merchant_name")
  private String merchantName;

  @Deprecated
  @Column(name = "merchant_siteId", nullable = true)
  private String merchantSiteId;

  @Column(name = "status")
  private boolean status;

  @Column(name = "merchant_status")
  @Enumerated(EnumType.STRING)
  MerchantStatus merchantStatus;

  @Column(name = "kyc_approval_status")
  @Enumerated(EnumType.STRING)
  KycApprovalStatus kycApprovalStatus;

  @Column(name = "wallet_address")
  private String walletAddress;

  @ColumnDefault("100")
  @Column(name = "doller_balance")
  private Double dollerBalance;

  @ColumnDefault("100")
  @Column(name = "euro_balance")
  private Double euroBalance;

  @ColumnDefault("100")
  @Column(name = "pound_balance")
  private Double poundBalance;

  @Column(name = "phone_no", nullable = false)
  private Long phoneNo;

  @Column(name = "phone_verified")
  private Boolean phoneVerified;

  @Column(name = "two_factor_status")
  private Boolean twoFactorStatus;

  @Column(name = "phone_verification_otp")
  private String phoneVerificationOTP;

  @OneToMany(fetch = FetchType.EAGER)
  private Set<User> users;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "root_user_id")
  @JsonBackReference
  private User rootUser;

  // Additional fields to complete Merchant registration workflow - start

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "industry_industry_id", nullable = true)
  private Industry industry;

  // Additional fields to complete Merchant registration workflow - end

  @Transient private String confirmPassword;

  @Transient private String role;

  @Transient private String planName;

  // additional fields for the referral program
  @Column(name = "referred_by_business_referral_code", unique = true, length = 256)
  String referredByBusinessReferralCode;

  private String wallet;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @ManyToMany(mappedBy = "merchants", fetch = FetchType.EAGER)
  private Set<MerchantGroup> merchantGroups;
}
