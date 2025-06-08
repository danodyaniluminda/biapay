package com.biapay.core.repository;

import com.biapay.core.constant.enums.AccountTransactionStatus;
import com.biapay.core.model.AccountTransaction;
import com.biapay.core.model.UserType;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface AccountTransactionRepository
    extends JpaRepository<AccountTransaction, Long>,
    JpaSpecificationExecutor<AccountTransaction> {

  @Query(
      "select count(accountTransaction) from AccountTransaction accountTransaction "
          + " join accountTransaction.sourceAccount account "
          + " where accountTransaction.createdDate >= :startDate and accountTransaction.createdDate < :endDate"
          + " and account.accountUserId = :accountUserId and account.accountUserType = :accountUserType")
  Long todayTransactionCount(
      Instant startDate, Instant endDate, String accountUserId, UserType accountUserType);

  @Query(
      "select sum(accountTransaction.amount + accountTransaction.fees) from AccountTransaction accountTransaction "
          + " join accountTransaction.sourceAccount account "
          + " where accountTransaction.createdDate >= :startDate and accountTransaction.createdDate < :endDate"
          + " and account.accountUserId = :accountUserId and account.accountUserType = :accountUserType")
  BigDecimal todayTransactionAmount(
      Instant startDate, Instant endDate, String accountUserId, UserType accountUserType);

  @Query(value = "SELECT nextval('account_transaction_account_transaction_id_seq')", nativeQuery = true)
  Long getNextId();

  List<AccountTransaction> findAllByTransactionStatusAndIsProcessed(
      AccountTransactionStatus transactionStatus, boolean isProcessed);

  boolean existsAccountTransactionByTransactionRefAndTransactionStatus(UUID transactionRef, AccountTransactionStatus transactionStatus);
  List<AccountTransaction> findAllByTransactionRefAndTransactionStatus(UUID transactionRef, AccountTransactionStatus transactionStatus);
  boolean existsAccountTransactionByUniqueRefAndTransactionStatus(String uniqueRef, AccountTransactionStatus transactionStatus);
  boolean existsAccountTransactionByUniqueRef(String uniqueRef);
  boolean existsAccountTransactionByTransactionRefAndSourceUserIdAndReceiverUserIdAndTransactionStatus(UUID transactionRef, Long sourceUserId, Long receiverUserId, AccountTransactionStatus transactionStatus);
}
