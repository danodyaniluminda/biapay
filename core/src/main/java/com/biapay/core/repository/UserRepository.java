package com.biapay.core.repository;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.constant.enums.MerchantStatus;
import com.biapay.core.model.MFAStatus;
import com.biapay.core.model.Role;
import com.biapay.core.model.User;
import com.biapay.core.model.UserStatus;
import com.biapay.core.model.UserType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
  @Query(
      "select user from User user "
          + "left join fetch user.groups grp "
          + "where user.email = :email")
  Optional<User> findUserByEmail(String email);

  Optional<User> findByMobileNumberAndUserType(String mobile, UserType userType);

  @Query(
      "select user from User user "
          + "left join fetch user.groups grp "
          + "left join fetch user.merchant "
          + "left join fetch user.customerData "
          + "left join fetch user.merchantShops shop "
          + "left join fetch user.merchantPOSs pos "
          + "left join fetch pos.shop "
          + "where user.email = :email "
          + "and user.userType = :userType")
  Optional<User> findUserByEmailAndUserType(String email, UserType userType);

  @Query(
      "select user from User user "
          + "left join fetch user.groups grp "
          + "left join fetch user.merchant "
          + "left join fetch user.customerData "
          + "left join fetch user.merchantShops shop "
          + "left join fetch user.merchantPOSs pos "
          + "left join fetch pos.shop "
          + "where user.mobileNumber = :number "
          + "and user.userType = :userType")
  Optional<User> findUserByMobileNumberAndUserType(String number, UserType userType);

  List<User> findUserByUserType(UserType userType);

  @Query(
      "select user from User user "
          + "left join fetch user.groups grp "
          + "left join fetch user.merchant "
          + "left join fetch user.customerData "
          + "left join fetch user.merchantShops shop "
          + "left join fetch user.merchantPOSs pos "
          + "left join fetch pos.shop "
          + "where user.userId = :userId ")
  Optional<User> findByUserId(long userId);

  @Query(
      "select user from User user "
          + "left join fetch user.groups grp "
          + "left join fetch user.merchant "
          + "left join fetch user.customerData "
          + "left join fetch user.merchantShops shop "
          + "left join fetch user.merchantPOSs pos "
          + "left join fetch pos.shop "
          + "where user.userId = :userId and shop.shopId = :shopId")
  Optional<User> findByUserIdAndShopId(Long userId, Long shopId);

  @Query(
      "select user from User user "
          + "left join fetch user.groups grp "
          + "left join fetch user.merchant "
          + "left join fetch user.customerData "
          + "left join fetch user.merchantShops shop "
          + "left join fetch user.merchantPOSs pos "
          + "left join fetch pos.shop "
          + "where user.userId = :userId and pos.id = :posId")
  Optional<User> findByUserIdAndPosId(Long userId, Long posId);

  Optional<User> findByEmailVerificationToken(String token);

  Optional<User> findByResetPasswordToken(String resetPasswordToken);

  @Query(
      "select user from User user "
          + "left join fetch user.groups grp "
          + "left join fetch user.merchantPOSs merchantPOS "
          + "left join fetch merchantPOS.shop shop "
          + "left join fetch shop.merchant merchant "
          + "where merchantPOS.id in :posMerchants "
          + "and merchant.id = :merchantId")
  List<User> findByMerchantPOSs(List<Long> posMerchants, Long merchantId);

  @Query(
      "select user from User user "
          + "left join fetch user.groups grp "
          + "left join fetch user.customerData "
          + "left join fetch user.merchantShops merchantShop "
          + "left join fetch merchantShop.merchant merchant "
          + "where merchantShop.shopId in :shopIds "
          + "and merchant.id = :merchantId "
          + "and user.userType = :userType")
  List<User> findMerchantShopUser(List<Long> shopIds, Long merchantId, UserType userType);

  @Query("select user from User user " + "where :role MEMBER OF user.roles")
  List<User> findUserByRole(Role role);

  int countAllByEmailAndUserType(String email, UserType userType);

  int countAllByMobileNumberAndUserType(String phoneNumber, UserType userType);

  List<User> findAllByUserTypeAndUserStatus(UserType userType, UserStatus userStatus);

  // for get user without Kyc
  List<User> findByCustomerDataUserStatusOrMerchantMerchantStatus(
      UserStatus userStatus, MerchantStatus merchantStatus);

  @Query(value = "from User u where u.userStatus = :userStatus or u.kycStatus = :kycApprovalStatus ")
  List<User> findByCustomerDataUserStatusOrKycStatus(
      UserStatus userStatus, KycApprovalStatus kycApprovalStatus);

  Long countAllByUserTypeAndCreatedBy(UserType userType, String createdBy);

  //  Authenticator/MFA
  List<User> findAllByUserStatus(UserStatus userStatus);

  List<User> findAllByMfaStatus(MFAStatus mfaStatus);

  Optional<User> findByMobileNumber(String mobile);

  boolean existsByEmail(String email);

  User findByEmail(String email);

  @Query(
      nativeQuery = true,
      value =
          "select email from \"user\" where referred_by IS NOT NULL and user_id not in (select referral_reward_from_user_id from referral_rewarded)")
  List<String> findAllEmailsThatWasReferredAndWasNotRewardedFrom();

  User findByReferralCode(String referralCode);

  User findByEmailAndUserType(String email, UserType userType);

  List<User> findAllByReferredBy(String referredBy);

  User findByEmailAndUserTypeIn(String email, List<UserType> userType);

  @Query("from User user where user.email = :email and user.userType = :userType and user.isTwoFAEnabled = true")
  Optional<User> findUserByEmailAndUserTypeAndTwoFAEnabledIsTrue(String email, UserType userType);

  List<User> findAllByReferredByIsNotNull();

  List<User> findAllByReferralCodeIn(List<String> referralCodes);

//  2024-11-06
  List<User> findAllByMobileNumber(String mobileNumber);
  boolean existsByMobileNumber(String mobile);
//  boolean existsByEmail(String email);

  List<User> findAllByEmail(String email);




}
