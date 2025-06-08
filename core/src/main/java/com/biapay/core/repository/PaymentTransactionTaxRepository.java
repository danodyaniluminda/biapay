package com.biapay.core.repository;

import com.biapay.core.model.PaymentTransactionTax;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransactionTaxRepository extends
    JpaRepository<PaymentTransactionTax, Long> {

  @Override
  void deleteById(Long aLong);

  @Query("select f from PaymentTransactionTax f where f.service.id = ?1")
  List<PaymentTransactionTax> findAllByOperation(Long operationId);

  @Query("select f from PaymentTransactionTax f where f.service.id = ?1 and f.id <> ?2")
  List<PaymentTransactionTax> findAllByOperationExceptCurrent(Long operationId, Long feeId);

  @Query("select f from PaymentTransactionTax f where f.currency = ?1 and f.service.id = ?2 and f.lowerBound <= ?3 and f.upperBound >= ?3")
  PaymentTransactionTax findTaxByCurrencyOperationAmount(String currency, Long serviceId,
      BigDecimal amount);

  @Query("select f from PaymentTransactionTax f where f.currency = :currency and f.service.id = :serviceId")
  PaymentTransactionTax findByCurrencyAndServiceId(String currency, Long serviceId);

  Long countAllByServiceIs(Long serviceId);
}
