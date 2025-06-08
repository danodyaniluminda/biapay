package com.biapay.core.repository;

import com.biapay.core.model.Currency;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

  String save(String currencies);

  Optional<Currency> findByName(String name);

  Optional<Currency> findByCode(String code);

  Boolean existsByNameAndIdNot(String name, Long id);

  Boolean existsByCodeAndIdNot(String code, Long id);

  Optional<List<Currency>> findAllByIsDefault(Boolean isDefault);
}
