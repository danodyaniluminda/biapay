package com.biapay.core.repository;

import com.biapay.core.model.Email;
import com.biapay.core.model.EmailStatus;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepositoty extends JpaRepository<Email, UUID> {
  List<Email> findAllByStatus(EmailStatus emailStatus);
}
