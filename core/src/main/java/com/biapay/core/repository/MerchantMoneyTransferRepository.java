package com.biapay.core.repository;

import com.biapay.core.model.MerchantMoneyTransfer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantMoneyTransferRepository extends JpaRepository<MerchantMoneyTransfer, Long> {
  List<MerchantMoneyTransfer> findBySenderMerchantAccount(Long senderMerchantAccountId);

  List<MerchantMoneyTransfer> findBySenderMerchantAccountAndCurrency(Long senderMerchantAccount, String currency);

  Optional<MerchantMoneyTransfer> findByRef(UUID ref);
}
