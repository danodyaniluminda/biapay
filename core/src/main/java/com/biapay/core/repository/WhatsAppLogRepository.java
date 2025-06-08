package com.biapay.core.repository;

import com.biapay.core.model.WhatsAppLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhatsAppLogRepository extends JpaRepository<WhatsAppLog, Long> {}
