package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantSubscriptionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantSubscriptionHistoryRepository extends JpaRepository<MerchantSubscriptionHistory, Long> {
      List<MerchantSubscriptionHistory> findAllByMerchant(Merchant merchant);
}
