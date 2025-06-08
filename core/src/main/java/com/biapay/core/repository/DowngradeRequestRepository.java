package com.biapay.core.repository;

import com.biapay.core.model.DowngradeRequest;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DowngradeRequestRepository extends CrudRepository<DowngradeRequest, Long> {
  @Query(value = "SELECT * FROM downgrade_request ORDER BY id DESC LIMIT 1", nativeQuery = true)
  DowngradeRequest getLastrecord();

  @Query(value = "SELECT * FROM downgrade_request ORDER BY id DESC ", nativeQuery = true)
  List<DowngradeRequest> getList();

  @Query(
      "select downgradeRequest from DowngradeRequest downgradeRequest"
          + " left join fetch downgradeRequest.merchant merchant"
          + " where merchant.id = :merchantId")
  List<DowngradeRequest> findByMerchantId(Long merchantId);
}
