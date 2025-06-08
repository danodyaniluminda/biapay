package com.biapay.core.repository;

import com.biapay.core.model.Settlement;
import com.biapay.core.model.SettlementFinalTransaction;
import com.biapay.core.model.enums.SettlementStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementFinalTransactionRepository extends JpaRepository<SettlementFinalTransaction, Long> {

  List<SettlementFinalTransaction> findByMerchantPosId(Long merchantPosId);

  SettlementFinalTransaction findByClientTransactionId(UUID clientTransactionId);
  List<SettlementFinalTransaction> findByGroupId(UUID groupId);

  List<SettlementFinalTransaction> findBySettlementDate(LocalDate settlementDate);

  List<SettlementFinalTransaction> findAllByStatus(SettlementStatus status);

  List<SettlementFinalTransaction> findAllByStatusAndSettlementDate(
      SettlementStatus status, LocalDate settlementDate);

  List<SettlementFinalTransaction> findAllBySettlementDate(LocalDate settlementDate);

  @Query(
      value =
          "select settlement from SettlementFinalTransaction settlement "
              + " where settlement.settlementDate = :settlementDate "
              + " and settlement.settlementPeriodType <> :settlementPeriodType")
  List<SettlementFinalTransaction> findNonRealTimeSettlementByDate(
      LocalDate settlementDate, String settlementPeriodType);

  Page<SettlementFinalTransaction> findAll(Pageable pageable);
  List<SettlementFinalTransaction> findAll();

  Page<SettlementFinalTransaction> findAllBySettlementDate(LocalDate settlementDate, Pageable pageable);

  @Query(
      value =
          "select settlement from SettlementFinalTransaction settlement "
              + " where settlement.settlementDate = :settlementDate "
              + " and settlement.status = :settlementStatus")
  List<SettlementFinalTransaction> findAllSettlementByDateAndStatus(
      LocalDate settlementDate, SettlementStatus settlementStatus);

  @Query(
      "SELECT st FROM SettlementFinalTransaction st "
          + "JOIN MerchantPOS mp on mp.id = st.merchantPosId "
          + "JOIN mp.shop s on s.shopId = mp.shop.shopId "
          + "WHERE s.merchant.id = ?2 "
          + "AND mp.id = st.merchantPosId "
          + "AND st.settlementDate = ?1")
  Page<SettlementFinalTransaction> findByMerchantIdAndDate(
      LocalDate settlementDate, Long merchantId, Pageable pageable);

  @Query(
      value =
          "select settlement from SettlementFinalTransaction settlement "
              + " where settlement.settlementDate = :settlementDate "
              + " and settlement.settlementPeriodType <> :settlementPeriodType"
              + " and settlement.status = :status")
  List<SettlementFinalTransaction> findNonRealTimeSettlementByDateAndStatus(
      LocalDate settlementDate, String settlementPeriodType, SettlementStatus status);

  @Query(
      value =
          "select st from SettlementFinalTransaction st "
              + " where st.settlementDate = :settlementDate "
              + " and st.groupId is not null")
  List<SettlementFinalTransaction> findNonRealTimeGroupedSettlementByDate(LocalDate settlementDate);

  @Query(
      value =
          "select st from SettlementFinalTransaction st "
              + " where st.settlementDate = :settlementDate and st.merchantPosId = :merchantPosId"
              + " and st.groupId is not null")
  List<SettlementFinalTransaction> findNonRealTimeGroupedSettlementByDateAndMerchantPosId(LocalDate settlementDate, Long merchantPosId);

  Optional<SettlementFinalTransaction> findBySettlementRef(UUID settlementRef);
}
