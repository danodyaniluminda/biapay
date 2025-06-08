package com.biapay.core.repository;

import com.biapay.core.dto.CountryDTO;
import com.biapay.core.model.Country;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Long> {
  Optional<Country> findByIso3(String name);

  Optional<Country> findByPhonecode(int phoneCode);

  List<Country> findAllByGimacPayEnabled(boolean gimacPayEnabled);

  @Query("SELECT new com.biapay.core.dto.CountryDTO(c.id, c.shortName, c.longName) " +
      "FROM Country c " +
      "WHERE c.gimacPayEnabled = :gimacPayEnabled")
  List<CountryDTO> findAllGIMACPayCountries(boolean gimacPayEnabled);
}
