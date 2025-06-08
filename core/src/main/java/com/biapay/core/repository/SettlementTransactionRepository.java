package com.biapay.core.repository;

import com.biapay.core.model.SettlementTransaction;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementTransactionRepository
    extends JpaRepository<SettlementTransaction, UUID> {

  Optional<SettlementTransaction> findById(UUID id);
}
