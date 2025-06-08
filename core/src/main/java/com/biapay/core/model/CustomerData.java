package com.biapay.core.model;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Setter
@Getter
@Entity
@Table(
    name = "customer_data",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "customer_data_email_index",
          columnNames = {"email"}),
      @UniqueConstraint(
          name = "customer_data_phone_no_index",
          columnNames = {"phone_no"})
    })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user"})
public class CustomerData extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_data_seq")
  @SequenceGenerator(
      name = "customer_data_seq",
      allocationSize = 1,
      sequenceName = "customer_data_seq")
  @Column(name = "customer_id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "userName")
  private String userName;

  @Column(name = "email", nullable = true)
  private String email;

  @Column(name = "phone_no", nullable = false)
  private Long phoneNo;

  @Transient private String password;

  @Column(name = "wallet_address")
  private String walletAddress;

  @ColumnDefault("0")
  @Column(name = "doller_balance")
  private Double dollerBalance;

  @ColumnDefault("0")
  @Column(name = "euro_balance")
  private Double euroBalance;

  @ColumnDefault("0")
  @Column(name = "pound_balance")
  private Double poundBalance;

  @Column(name = "two_factor_status")
  private Boolean twoFactorStatus;

  @ColumnDefault("0")
  @Column(name = "two_factor_code")
  private Double twoFactorCode;

  @ColumnDefault("0")
  @Column(name = "web_authorization")
  private String otp;

  @Column(name = "email_verified")
  private Boolean emailVerified;

  @Column(name = "phone_verified")
  private Boolean phoneVerified;

  @Column(name = "user_status")
  @Enumerated(EnumType.STRING)
  private UserStatus userStatus;

  @Column(name = "phone_verification_otp")
  private String phoneVerificationOTP;

  @Transient private String confirmPassword;

  @Transient private Double confirmPin;

  @Transient private Double oldPin;

  @Transient private String role;

  @Column(name = "devive_Udid")
  private String deviveUdid;

  @Column(name = "status")
  private boolean status;

  @Transient private String firstName;

  @Transient private String lastName;

  @Column(name = "uuid", unique = true)
  private UUID uuid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "qrcode_upload_id")
  private Upload qrCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "barcode_upload_id")
  private Upload barCode;

  // for the referral program
  @Column(name = "referred_by_business_referral_code", unique = true, length = 256)
  String referredByBusinessReferralCode;

  @Column(name = "kyc_approval_status")
  @Enumerated(EnumType.STRING)
  private KycApprovalStatus kycApprovalStatus;
}
