package com.biapay.core.repository;

import com.biapay.core.constant.enums.AccountTransactionStatus;
import com.biapay.core.model.AccountPendingTransaction;
import com.biapay.core.model.enums.AccountTransactionType;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface AccountPendingTransactionRepository
    extends JpaRepository<AccountPendingTransaction, Long>,
    JpaSpecificationExecutor<AccountPendingTransaction> {

  @Query(value = "SELECT nextval('account_pending_transactions_id_seq')", nativeQuery = true)
  Long getNextId();

  List<AccountPendingTransaction> findAllByTransactionStatusAndIsProcessed(
      AccountTransactionStatus transactionStatus, boolean isProcessed);

  List<AccountPendingTransaction> findAllByIsProcessed(boolean isProcessed);

  List<AccountPendingTransaction> findAllByTransactionDateAndIsProcessed(LocalDate transactionDate,
      boolean isProcessed);

  Optional<AccountPendingTransaction> findFirstByTransactionId(UUID transactionId);
  List<AccountPendingTransaction> findAllByTransactionId(UUID transactionId);
  Optional<AccountPendingTransaction> findFirstByUniqueRef(String uniqueRef);
  List<AccountPendingTransaction> findAllByTransactionIdAndTransactionStatus(UUID transactionId, AccountTransactionStatus transactionStatus);

  List<AccountPendingTransaction> findAllByTransactionDate(LocalDate transactionDate);

  List<AccountPendingTransaction> findAllByTransactionStatus(
      AccountTransactionStatus transactionStatus);

  List<AccountPendingTransaction> findAllByTransactionType(AccountTransactionType transactionType);

}
