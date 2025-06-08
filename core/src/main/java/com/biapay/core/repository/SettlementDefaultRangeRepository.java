package com.biapay.core.repository;

import com.biapay.core.model.SettlementDefaultRange;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementDefaultRangeRepository
    extends JpaRepository<SettlementDefaultRange, Long> {

  Optional<SettlementDefaultRange> findByCurrencyId(Long currency);

  Boolean existsByCurrencyId(Long currencyId);

  @Modifying(clearAutomatically = true)
  @Query(
      "update SettlementDefaultRange set settlementLimitX=:settlementLimitX, settlementLimitY =:settlementLimitY where currencyId=:currencyId")
  int updateSettlementRange(
      @Param("settlementLimitX") BigDecimal settlementLimitX,
      @Param("settlementLimitY") BigDecimal settlementLimitY,
      @Param("currencyId") Long currencyId);
}
