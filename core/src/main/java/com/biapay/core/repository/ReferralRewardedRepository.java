package com.biapay.core.repository;

import com.biapay.core.model.ReferralRewarded;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferralRewardedRepository extends JpaRepository<ReferralRewarded, Long> {

  List<ReferralRewarded> findAllByReferralBeneficiaryCode(String referralBeneficiaryCode);
}
