package com.biapay.core.repository;

import com.biapay.core.model.MFACode;
import com.biapay.core.model.UserType;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MFACodeRepository extends JpaRepository<MFACode, Long> {
  @Query(
      value =
          "from MFACode mf where mf.userType = :userType and mf.phoneNumber = :phoneNumber and mf.used = :isUsed and mf.expired =:isExpired and date(mf.createdDate) > :currentMinusGrace order by mf.createdDate desc")
  List<MFACode> findAllByUserTypeAndPhoneNumberAndUsedAndExpiredAndCreatedDateGreaterThan(
      UserType userType,
      String phoneNumber,
      boolean isUsed,
      boolean isExpired,
      Date currentMinusGrace);

  @Query(
      value =
          "from MFACode mf where mf.userType = :userType and mf.phoneNumber = :phoneNumber and mf.used = :isUsed and mf.expired =:isExpired and :localDateTime <= mf.expiryDate order by mf.createdDate desc")
  List<MFACode> findAllByUserTypeAndPhoneNumberAndUsedAndExpiredAndExpiryDateLessThanEqual(
      UserType userType,
      String phoneNumber,
      boolean isUsed,
      boolean isExpired,
      LocalDateTime localDateTime);

  List<MFACode> findAllByPhoneNumberAndUsedAndExpiredAndCreatedDateGreaterThan(
      String phoneNumber, boolean isUsed, boolean isExpired, Date currentMinusGrace);

  @Query(
      value =
          "from MFACode mf where mf.phoneNumber = :phoneNumber and mf.used = :isUsed and mf.expired =:isExpired and :localDateTime <= mf.expiryDate order by mf.createdDate desc")
  List<MFACode> findAllByPhoneNumberAndUsedAndExpiredAndExpiryDateLessThanEqual(
      String phoneNumber, boolean isUsed, boolean isExpired, LocalDateTime localDateTime);

  List<MFACode> findAllByExpiredAndCreatedDateLessThan(boolean isExpired, Date currentMinusGrace);

  List<MFACode> findByUserIdAndUsedAndViaAuthenticatorAndGeneratedAtGreaterThan(
      String userId, boolean isUsed, boolean viaAuthenticator, LocalDateTime currentMinusGrace);

  List<MFACode> findByUserIdAndUsedAndViaAuthenticatorAndExpiryDateLessThanEqual(
      String userId, boolean isUsed, boolean viaAuthenticator, LocalDateTime currentMinusGrace);

  List<MFACode> findByUserIdAndUsedAndViaAuthenticatorAndExpiryDateGreaterThan(
      String userId, boolean isUsed, boolean viaAuthenticator, LocalDateTime currentMinusGrace);

  List<MFACode> findByUserIdAndUsedAndViaPushNotificationAndGeneratedAtGreaterThan(
      String userId, boolean isUsed, boolean viaPushNotification, LocalDateTime currentMinusGrace);

  List<MFACode> findByUserIdAndUsedAndViaPushNotificationAndExpiredGreaterThanEqual(
      String userId, boolean isUsed, boolean viaPushNotification, LocalDateTime currentMinusGrace);

  MFACode findFirstByMfaHash(String mfaHash);

  List<MFACode> findAllByUserIdAndCreatedDateIsAfter(String userId, Date createdAfter);

  List<MFACode> findAllByUserIdAndExpiredIsFalseAndUsedIsFalseAndExpiryDateGreaterThanEqual(
      String userId, LocalDateTime expiryDate);
}
