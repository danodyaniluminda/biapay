package com.biapay.core.repository;

import com.biapay.core.model.PSPTransactionFee;
import com.biapay.core.model.enums.PSPTransactionType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PSPTransactionFeeRepository extends JpaRepository<PSPTransactionFee, Long> {
  PSPTransactionFee findByPaymentMethodIdAndCurrencyAndPspTransactionType(Long paymentMethodId,
      String currency, PSPTransactionType pspTransactionType);
  PSPTransactionFee findBySettlementMethodIdAndCurrencyAndPspTransactionType(Long settlementMethodId,
      String currency, PSPTransactionType pspTransactionType);
  PSPTransactionFee findByPaymentMethodIdAndCurrency(Long paymentMethodId, String currency);
  List<PSPTransactionFee> findAllByPaymentMethodId(Long paymentMethodId);
  List<PSPTransactionFee> findAllByCurrency(String currency);
}
