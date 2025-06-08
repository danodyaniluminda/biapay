package com.biapay.core.repository;

import com.biapay.core.model.Settlement;
import com.biapay.core.model.enums.SettlementStatus;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {

  List<Settlement> findByMerchantPosId(Long merchantPosId);

  Settlement findByClientTransactionId(UUID clientTransactionId);

  @Query("SELECT s FROM Settlement s WHERE s.clientTransactionId = :clientTransactionId")
  Settlement findSettlementForUpdate(@Param("clientTransactionId") UUID clientTransactionId);

  List<Settlement> findByGroupId(UUID groupId);

  List<Settlement> findBySettlementDate(LocalDate settlementDate);

  List<Settlement> findAllByStatus(SettlementStatus status);

  List<Settlement> findAllByStatusAndSettlementDate(
      SettlementStatus status, LocalDate settlementDate);

  List<Settlement> findAllBySettlementDate(LocalDate settlementDate);

  @Query(
      value =
          "select settlement from Settlement settlement "
              + " where settlement.settlementDate = :settlementDate "
              + " and settlement.settlementPeriodType <> :settlementPeriodType")
  List<Settlement> findNonRealTimeSettlementByDate(
      LocalDate settlementDate, String settlementPeriodType);

  Page<Settlement> findAll(Pageable pageable);

  List<Settlement> findAll();

  Page<Settlement> findAllBySettlementCurrencyContains(String currency, Pageable pageable);

  Page<Settlement> findAllBySettlementDate(LocalDate settlementDate, Pageable pageable);

  @Query(
      value =
          "select settlement from Settlement settlement "
              + " where settlement.settlementDate = :settlementDate "
              + " and settlement.status = :settlementStatus")
  List<Settlement> findAllSettlementByDateAndStatus(
      LocalDate settlementDate, SettlementStatus settlementStatus);

  @Query(
      "SELECT st FROM Settlement st "
          + "JOIN MerchantPOS mp on mp.id = st.merchantPosId "
          + "JOIN mp.shop s on s.shopId = mp.shop.shopId "
          + "WHERE s.merchant.id = ?2 "
          + "AND mp.id = st.merchantPosId "
          + "AND st.settlementDate = ?1")
  Page<Settlement> findByMerchantIdAndDate(
      LocalDate settlementDate, Long merchantId, Pageable pageable);

//  @Query(
//      value =
//          "select st.merchantPosId, st.paymentMethodId from Settlement st where st.settlementDate = :settlementDate and st.status = :settlementStatus group by st.merchantPosId, st.paymentMethodId")
//  List<Settlement> findAllGroupedSettlementByDateAndStatus(
//      LocalDate settlementDate, SettlementStatus settlementStatus);

  @Query(
      value =
          "select settlement from Settlement settlement "
              + " where settlement.settlementDate = :settlementDate "
              + " and settlement.settlementPeriodType <> :settlementPeriodType"
              + " and settlement.status = :status")
  List<Settlement> findNonRealTimeSettlementByDateAndStatus(
      LocalDate settlementDate, String settlementPeriodType, SettlementStatus status);

  @Query(
      value =
          "select st from Settlement st "
              + " where st.settlementDate = :settlementDate "
              + " and st.groupId is not null")
  List<Settlement> findNonRealTimeGroupedSettlementByDate(LocalDate settlementDate);

  @Query(
      value =
          "select st from Settlement st "
              + " where st.settlementDate = :settlementDate and st.merchantPosId = :merchantPosId"
              + " and st.groupId is not null")
  List<Settlement> findNonRealTimeGroupedSettlementByDateAndMerchantPosId(LocalDate settlementDate,
      Long merchantPosId);


  Optional<Settlement> findBySettlementRef(UUID settlementRef);

  List<Settlement> findByStatusAndSettlementDateLessThanEqual(SettlementStatus status,
      LocalDate settlementDate);

  @Query("SELECT s.clientTransactionId FROM Settlement s WHERE s.status = :status AND s.createdDate > :createdDate")
  List<UUID> findClientTransactionIdsByStatusAndCreatedDateAfter(
      @Param("status") SettlementStatus status,
      @Param("createdDate") Date createdDate);

  Optional<Settlement> findBySettlementTransactionId(UUID settlementTransactionId);
}
