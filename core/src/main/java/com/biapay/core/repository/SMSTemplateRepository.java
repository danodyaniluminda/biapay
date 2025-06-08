package com.biapay.core.repository;

import com.biapay.core.model.SMSTemplate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSTemplateRepository extends JpaRepository<SMSTemplate, Long> {
  Optional<SMSTemplate> findSMSTemplateByTemplateNameAndLocale(String templateName, String locale);
}
