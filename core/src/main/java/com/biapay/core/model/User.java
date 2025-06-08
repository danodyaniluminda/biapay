package com.biapay.core.model;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.model.views.UserView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(
    name = "`user`",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "emailAndUserType",
          columnNames = {"email", "userType"})
    })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User extends Auditable<String> implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  @SequenceGenerator(name = "user_seq", allocationSize = 1, sequenceName = "user_seq")
  @JsonView({UserView.SearchView.class})
  private Long userId;

  @Column(nullable = true)
  @JsonView({UserView.SearchView.class})
  private String email;

  @JsonView({UserView.SearchView.class})
  private String name;

  @JsonView({UserView.SearchView.class})
  private String firstName;

  @JsonView({UserView.SearchView.class})
  private String lastName;

  @JsonView({UserView.SearchView.class})
  private String mobileNumber;

  private String username;

  @JsonIgnore
  private String password;

  private Integer failedLoginCount = 0;

  private Long lastSuccessLoginAt;

  @Enumerated(EnumType.STRING)
  private MFAStatus mfaStatus;

  @JsonView({UserView.SearchView.class})
  @Enumerated(EnumType.STRING)
  private UserType userType;

  @Enumerated(EnumType.STRING)
  private UserStatus userStatus;

  @Enumerated(EnumType.STRING)
  private UserStatus previousStatus;

  @Column(name = "kyc_status")
  @Enumerated(EnumType.STRING)
  private KycApprovalStatus kycStatus;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  @JsonIgnore
  private Set<Role> roles;

  @ManyToOne
  @JoinColumn(name = "merchant_id")
  @JsonManagedReference
  private Merchant merchant;

  @ManyToMany
  @JoinTable(
      name = "merchant_pos_user",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "merchant_pos_id"))
  private Set<MerchantPOS> merchantPOSs;

  @ManyToMany
  @JoinTable(
      name = "merchant_shop_user",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "merchant_shop_id"))
  private Set<Shop> merchantShops;

  @OneToOne(mappedBy = "user")
  private CustomerData customerData;

  @ManyToMany
  @JoinTable(
      name = "user_group",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<Group> groups;

  private String emailVerificationToken;

  @ColumnDefault(value = "false")
  private boolean isEmailVerified;

  @ColumnDefault(value = "false")
  @Column(name = "is_twofaenabled")
  private boolean isTwoFAEnabled;

  @ManyToOne
  @JoinColumn(name = "language_id")
  private Language language;

  private String resetPasswordToken;

  @Transient private String confirmPassword;

  // start: additional attributes and method for referral program
  @ColumnDefault(value = "false")
  @Column(name = "is_reward_granted", nullable = true)
  private boolean isRewardGranted;

  @Column(name = "device_id")
  private String deviceId;

  @Column(name = "whatsapp_number")
  private String whatsAppNumber;

  @Column(name = "referral_code")
  private String referralCode;

  @Column(name = "referred_by")
  private String referredBy;

  public User(Long userId) {
    this.userId = userId;
  }

  public Optional<String> getBusinessID() {
    String businessID = null;
    if (getMerchant() != null) {
      businessID = getMerchant().getWalletAddress();
    } else {
      if (getCustomerData() != null) {
        businessID = getCustomerData().getWalletAddress();
      } else {
        return Optional.empty();
      }
    }
    return Optional.of(businessID);
  }

  public Optional<String> getReferredByBusinessReferralCode() {
    if (this.getMerchant() != null
        && this.getMerchant().getReferredByBusinessReferralCode() != null) {
      return Optional.of(this.getMerchant().getReferredByBusinessReferralCode());
    }
    if (this.getCustomerData() != null
        && this.getCustomerData().getReferredByBusinessReferralCode() != null) {
      return Optional.of(this.getCustomerData().getReferredByBusinessReferralCode());
    }

    return Optional.empty();
  }

  // end of: additional attributes and method for referral program

//  public void addRole(Role role) {
//    if (this.roles != null) {
//      this.roles.add(role);
//    } else {
//      this.setRoles(new HashSet<>());
//      this.roles.add(role);
//    }
//  }

  @Override
  public boolean isAccountNonExpired() {
    if (userStatus != null && userStatus.equals(UserStatus.ACCOUNT_EXPIRED)) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public boolean isAccountNonLocked() {
    // neither suspended user nor locked user can login
    if (userStatus != null
        && (userStatus.equals(UserStatus.LOCKED) || userStatus.equals(UserStatus.SUSPENDED))) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public boolean isEnabled() {
    if (userStatus != null && userStatus.equals(UserStatus.ACTIVE)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isCredentialsNonExpired() {
    if (userStatus != null && userStatus.equals(UserStatus.PASSWORD_EXPIRED)) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }
}
