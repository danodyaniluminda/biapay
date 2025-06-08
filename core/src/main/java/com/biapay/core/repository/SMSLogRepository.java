package com.biapay.core.repository;

import com.biapay.core.model.SMSLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSLogRepository extends JpaRepository<SMSLog, Long> {}
