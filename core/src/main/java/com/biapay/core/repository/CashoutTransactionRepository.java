package com.biapay.core.repository;

import com.biapay.core.model.CashoutTransaction;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashoutTransactionRepository extends JpaRepository<CashoutTransaction, Long> {
  CashoutTransaction findByCashoutTransactionId(UUID cashoutTransactionId);
}
