package com.biapay.core.repository;

import com.biapay.core.model.OTPAuthCode;
import java.sql.Timestamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPAuthCodeRepository extends JpaRepository<OTPAuthCode, Long> {

  OTPAuthCode findByAuthCodeAndUserIdAndExpiredIsFalseAndExpiryDateAfter(
      String authCode, long userId, Timestamp expiryDate);

  OTPAuthCode findByAuthCodeAndExpiredIsFalseAndExpiryDateAfter(
      String authCode, Timestamp expiryDate);

  OTPAuthCode findByAuthCodeAndUserIdAndExpiryDateAfter(
      String authCode, long userId, Timestamp expiryDate);

  OTPAuthCode findByAuthCodeAndExpiryDateAfter(String authCode, Timestamp expiryDate);
}
