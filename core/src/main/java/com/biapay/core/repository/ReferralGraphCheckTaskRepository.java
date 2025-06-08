package com.biapay.core.repository;

import com.biapay.core.model.ReferralGraphCheckTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferralGraphCheckTaskRepository
    extends JpaRepository<ReferralGraphCheckTask, Long> {}
