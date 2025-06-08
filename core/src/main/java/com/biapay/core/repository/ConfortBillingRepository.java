package com.biapay.core.repository;

import com.biapay.core.model.ConfortBilling;
import com.biapay.core.model.Merchant;
import com.biapay.core.model.PayLink;
import com.biapay.core.model.enums.ConfortBillingStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConfortBillingRepository extends JpaRepository<ConfortBilling, Long> {

  List<ConfortBilling> findAllByStatus(ConfortBillingStatus status);
  List<ConfortBilling> findAllByPayLink(PayLink payLink);

  @Query(value = "from ConfortBilling cb where cb.merchant.id = :merchantId and cb.status = :status")
  List<ConfortBilling> findAllByMerchantIdAndStatus(Long merchantId, ConfortBillingStatus status);
}
