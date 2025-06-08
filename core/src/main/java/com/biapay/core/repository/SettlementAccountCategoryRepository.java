package com.biapay.core.repository;

import com.biapay.core.model.SettlementAccountCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SettlementAccountCategoryRepository extends CrudRepository<SettlementAccountCategory, Long> {
  Optional<SettlementAccountCategory> findByName(String name);
  List<SettlementAccountCategory> findAll();

}
