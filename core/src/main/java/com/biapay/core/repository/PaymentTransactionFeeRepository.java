package com.biapay.core.repository;

import com.biapay.core.model.PaymentTransactionFee;
import com.biapay.core.model.TransactionFee;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransactionFeeRepository extends JpaRepository<PaymentTransactionFee, Long> {
  @Override
  void deleteById(Long aLong);

  @Query("select f from PaymentTransactionFee f where f.service.id = ?1")
  List<PaymentTransactionFee> findAllByOperation(Long operationId);

  @Query("select f from PaymentTransactionFee f where f.service.id = ?1 and f.id <> ?2")
  List<PaymentTransactionFee> findAllByOperationExceptCurrent(Long operationId, Long feeId);

  @Query("select f from PaymentTransactionFee f where f.currency = ?1 and f.service.id = ?2 and f.lowerBound <= ?3 and f.upperBound >= ?3")
  PaymentTransactionFee findFeeByCurrencyOperationAmount(String currency, Long serviceId, BigDecimal amount);

  Long countAllByServiceIs(Long serviceId);
}
