package com.biapay.core.repository;

import com.biapay.core.model.MFAMethod;
import com.biapay.core.model.MFAMethodType;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MFAMethodRepository extends JpaRepository<MFAMethod, MFAMethodType> {
  @Query(value = "from MFAMethod mfaMethod order by mfaMethod.sortOrder")
  Set<MFAMethod> findAllOrderBySortId();
}
