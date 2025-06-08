package com.biapay.core.repository;

import com.biapay.core.model.OneTimePassword;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OneTimePasswordRepository extends JpaRepository<OneTimePassword, UUID> {
  Optional<OneTimePassword> findByClientTransactionIdAndValidTillAfterAndOtp(
      UUID clientTransactionId, LocalDateTime currentTime, String otp);
}
