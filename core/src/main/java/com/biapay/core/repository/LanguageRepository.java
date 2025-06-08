package com.biapay.core.repository;

import com.biapay.core.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
  Language findByName(String nmae);
}
