package com.biapay.core.repository;

import com.biapay.core.model.BusinessType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long> {

  List<BusinessType> findAllByIndustryIndustryId(Long industryId);
}
