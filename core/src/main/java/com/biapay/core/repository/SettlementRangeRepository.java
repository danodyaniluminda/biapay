package com.biapay.core.repository;

import com.biapay.core.model.SettlementRange;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRangeRepository
    extends JpaRepository<SettlementRange, SettlementRange.SettlementRangeId> {

  List<SettlementRange> findByMerchantPosId(Long merchantPosId);

  @Query(
      "select settlementRange from SettlementRange settlementRange "
          + " where settlementRange.isDefault = true and settlementRange.currency = :ccy")
  Optional<SettlementRange> findDefaultRangeByCurrency(String ccy);
}
