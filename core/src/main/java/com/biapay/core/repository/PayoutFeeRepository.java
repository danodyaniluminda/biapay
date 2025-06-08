package com.biapay.core.repository;

import com.biapay.core.model.PayoutFee;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PayoutFeeRepository extends JpaRepository<PayoutFee, Long> {
  @Query("select f from PayoutFee f where f.fromService.id = ?1")
  List<PayoutFee> findAllByFromService(Long serviceId);

  @Query("select f from PayoutFee f where f.toService.id = ?1")
  List<PayoutFee> findAllByToService(Long serviceId);

  @Query("select f from PayoutFee f where f.toService.id = ?1 and f.lowerBound <= ?2 and f.upperBound >= ?2")
  List<PayoutFee> findAllByToServiceAndAmount(Long serviceId, BigDecimal amount);

  @Query("select f from PayoutFee f where f.toService.id = ?1 and f.fromService.id = ?2")
  List<PayoutFee> findAllByToServiceAndFromService(Long toServiceId, Long fromServiceId);

  @Query("select f from PayoutFee f where f.toService.id = ?1 and f.fromService.id = ?2 and f.currency = ?3 and f.id <> ?4")
  List<PayoutFee> findAllByToServiceAndFromServiceAndCurrencyExceptCurrent(Long toServiceId, Long fromServiceId, String currency, Long feeId);

  @Query("select f from PayoutFee f where f.toService.id = ?1 and f.fromService.id = ?2 and f.currency = ?3")
  List<PayoutFee> findAllByToServiceAndFromServiceAndCurrency(Long toServiceId, Long fromServiceId, String currency);

  @Query("select f from PayoutFee f where f.toService.id = ?1 and f.fromService.id = ?2 and f.currency = ?3 and f.lowerBound <= ?4 and f.upperBound >= ?4")
  Optional<PayoutFee> findAllByToServiceAndFromServiceAndCurrencyAndAmount(Long toServiceId, Long fromServiceId, String currency, BigDecimal amount);

  @Query("select f from PayoutFee f where f.settlementMethodId = ?1 and f.currency = ?2 and f.lowerBound <= ?3 and f.upperBound >= ?3")
  Optional<PayoutFee> findAllBySettlementMethodIdAndCurrencyAndAmount(Long settlementMethodId, String currency, BigDecimal amount);
}
