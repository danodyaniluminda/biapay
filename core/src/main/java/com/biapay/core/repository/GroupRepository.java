package com.biapay.core.repository;

import com.biapay.core.model.Group;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group, Long> {
  @Query(
      "select grp from Group grp"
          + " left join grp.merchant merchant"
          + " where merchant.id = :merchantId")
  List<Group> findByMerchantId(Long merchantId);
}
