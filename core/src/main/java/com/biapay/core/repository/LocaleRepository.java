package com.biapay.core.repository;

import com.biapay.core.model.Locale;
import com.biapay.core.model.LocaleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocaleRepository extends JpaRepository<Locale, LocaleId> {
  Locale findByLocaleId(LocaleId localeId);
}
