package com.biapay.core.repository;

import com.biapay.core.model.PayoutService;
import com.biapay.core.model.PayoutServiceBalance;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayoutServiceBalanceRepository extends JpaRepository<PayoutServiceBalance, Long> {
  List<PayoutServiceBalance> findPayoutServiceBalancesByPayoutService(PayoutService payoutService);
  Optional<PayoutServiceBalance> findPayoutServiceBalanceByPayoutServiceAndCurrency(PayoutService payoutService, String currency);
}
