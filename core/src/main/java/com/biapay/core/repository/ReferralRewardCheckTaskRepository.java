package com.biapay.core.repository;

import com.biapay.core.model.ReferralRewardCheckTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferralRewardCheckTaskRepository
    extends JpaRepository<ReferralRewardCheckTask, Long> {}
