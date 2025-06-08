package com.biapay.core.repository;

import com.biapay.core.model.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
  @Query(
      "select emailTemplate from EmailTemplate emailTemplate"
          + " left outer join emailTemplate.language language"
          + " where emailTemplate.templateName = :templateName and language.id = :languageId")
  EmailTemplate findByTemplateNameAndLanguage(String templateName, Long languageId);
}
