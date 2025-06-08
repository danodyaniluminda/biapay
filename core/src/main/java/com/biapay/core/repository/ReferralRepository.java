package com.biapay.core.repository;

import com.biapay.core.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferralRepository extends JpaRepository<Referral, Long> {

  Referral findFirstByActiveTrue();
}
