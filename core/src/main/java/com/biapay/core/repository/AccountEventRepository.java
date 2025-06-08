package com.biapay.core.repository;

import com.biapay.core.model.AccountEvent;
import com.biapay.core.model.UserType;
import com.biapay.core.model.enums.AccountType;
import com.biapay.core.model.projection.AccountEventProjection;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AccountEventRepository extends JpaRepository<AccountEvent, Long> {

  @Query(
      "select accountEvent from AccountEvent accountEvent "
          + "join accountEvent.account account "
          + "join accountEvent.accountTransaction accountTransaction "
          + "where account.accountUserId = :accountUserId and account.accountUserType = :accountUserType and account.currencyCode in :currencyCodes and accountEvent.createdDate >= :fromDate and accountEvent.createdDate < :toDate")
  Page<AccountEvent> findAllByAccountUserIdAndUserTypeAndCurrencyCodeAndDate(
      @Param("accountUserId") Long accountUserId,
      @Param("accountUserType") UserType accountUserType,
      @Param("currencyCodes") List<String> currencyCodes,
      @Param("fromDate") Instant fromDate,
      @Param("toDate") Instant toDate,
      Pageable pageable);

  @Query(
      "select accountEvent from AccountEvent accountEvent "
          + "join accountEvent.account account "
          + "join accountEvent.accountTransaction accountTransaction "
          + "where account.accountUserId = :accountUserId and account.accountUserType = :accountUserType and accountEvent.createdDate >= :fromDate and accountEvent.createdDate < :toDate")
  Page<AccountEvent> findAllByAccountUserIdAndUserTypeAndDate(
      @Param("accountUserId") Long accountUserId,
      @Param("fromDate") Instant fromDate,
      @Param("toDate") Instant toDate,
      Pageable pageable);

  @Query(
      "select accountEvent from AccountEvent accountEvent "
          + "join accountEvent.account account "
          + "join accountEvent.accountTransaction accountTransaction "
          + "where account.accountUserId = :accountUserId and accountEvent.createdDate >= :fromDate and accountEvent.createdDate < :toDate")
  Page<AccountEvent> findAllByAccountUserIdAndDate(
      @Param("accountUserId") Long accountUserId,
      @Param("fromDate") Instant fromDate,
      @Param("toDate") Instant toDate,
      Pageable pageable);

  @Query(
      "select accountEvent from AccountEvent accountEvent "
          + "join accountEvent.account account "
          + "join accountEvent.accountTransaction accountTransaction "
          + "where account.accountUserId = :accountUserId and account.accountUserType = :accountUserType and account.currencyCode in :currencyCodes and accountEvent.createdDate >= :fromDate and accountEvent.createdDate < :toDate and accountType = :accountType")
  Page<AccountEvent> findAllByAccountUserIdAndUserTypeAndCurrencyCodeAndDateAndAccountType(
      @Param("accountUserId") Long accountUserId,
      @Param("accountUserType") UserType accountUserType,
      @Param("currencyCodes") List<String> currencyCodes,
      @Param("fromDate") Instant fromDate,
      @Param("toDate") Instant toDate,
      @Param("accountType") AccountType accountType,
      Pageable pageable);

  @Query(
      "select accountEvent from AccountEvent accountEvent "
          + "join accountEvent.account account "
          + "join accountEvent.accountTransaction accountTransaction "
          + "where account.currencyCode in :currencyCodes and accountEvent.createdDate >= :fromDate and accountEvent.createdDate < :toDate")
  Page<AccountEvent> findAllByCurrencyCodeAndDate(
      @Param("currencyCodes") List<String> currencyCodes,
      @Param("fromDate") Instant fromDate,
      @Param("toDate") Instant toDate,
      Pageable pageable);

  @Query(
      "select accountEvent from AccountEvent accountEvent "
          + "join accountEvent.account account "
          + "join accountEvent.accountTransaction accountTransaction "
          + "where accountEvent.createdDate >= :fromDate and accountEvent.createdDate < :toDate")
  Page<AccountEvent> findAllByDate(
      @Param("fromDate") Instant fromDate,
      @Param("toDate") Instant toDate,
      Pageable pageable);

  @Query(
      "select accountEvent from AccountEvent accountEvent "
          + "join accountEvent.account account "
          + "join accountEvent.accountTransaction accountTransaction "
          + "where accountEvent.accountTransaction.currencyCode=:currency and accountEvent.createdDate >= :fromDate and accountEvent.createdDate < :toDate")
  Page<AccountEvent> findAllByDateAndCurrency(
      @Param("fromDate") Instant fromDate,
      @Param("toDate") Instant toDate,
      @Param("currency") String currency,
      Pageable pageable);

  @Query(
      "select accountEvent from AccountEvent accountEvent "
          + "join accountEvent.account account "
          + "join accountEvent.accountTransaction accountTransaction "
          + "where accountTransaction.currencyCode = :currency and account.accountUserId = :accountUserId and accountEvent.createdDate >= :fromDate and accountEvent.createdDate < :toDate")
  Page<AccountEvent> findAllByAccountUserIdAndDateAndCurrency(
      @Param("accountUserId") Long accountUserId,
      @Param("fromDate") Instant fromDate,
      @Param("toDate") Instant toDate,
      @Param("currency") String currency,
      Pageable pageable);

  @Query(value = "SELECT DATE(created_date) AS transaction_date, SUM(amount) AS total_amount " +
      "FROM account_events " +
      "WHERE event_type = :eventType " +
      "AND account_type = :accountType " +
      "AND created_date >= NOW() - INTERVAL '30 days' " +
      "GROUP BY created_date " +
      "ORDER BY created_date DESC", nativeQuery = true)
  List<Tuple> getDailyTotalAmountSummary(@Param("eventType") String eventType,
      @Param("accountType") String accountType);

  @Query(value = "SELECT " +
      "at2.transaction_date AS transactionDate, " +
      "CAST(at2.transaction_ref AS TEXT) AS transactionRef, " +
      "ae.event_type AS eventType, " +
      "at2.currency_code AS currencyCode, " +
      "ae.amount AS amount, " +
      "ae.balance_before_transaction AS balanceBeforeTransaction, " +
      "ae.balance_after_transaction AS balanceAfterTransaction, " +
      "at2.transaction_type AS transactionType, " +
      "at2.transaction_source AS transactionSource " +
      "FROM account_events ae " +
      "INNER JOIN account_transactions at2 ON at2.id = ae.account_transaction_id " +
      "WHERE ae.account_id = :accountId " +
      "AND at2.transaction_date BETWEEN :startDate AND :endDate " +
      "ORDER BY ae.account_event_id",
      nativeQuery = true)
  List<AccountEventProjection> findAccountEventsForAccountBetweenDates(
      @Param("accountId") Long accountId,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
  );

}
