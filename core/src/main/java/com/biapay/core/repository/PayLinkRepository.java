package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.PayLink;
import com.biapay.core.model.PayLinkStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayLinkRepository extends JpaRepository<PayLink, Long> {
  Optional<PayLink> findByUuid(UUID uuid);

  Page<PayLink> findAllByStatus(PayLinkStatus status, Pageable pageable);

  List<PayLink> findByMerchant(Merchant merchant);

  Page<PayLink> findByMerchant(Merchant merchant, Pageable pageable);

  Page<PayLink> findByMerchantAndStatus(Merchant merchant, PayLinkStatus status, Pageable pageable);

  List<PayLink> findByMobileNumber(String mobileNumber);

  Page<PayLink> findByMobileNumber(String mobileNumber, Pageable pageable);

  Page<PayLink> findByMobileNumberAndStatus(
      String mobileNumber, PayLinkStatus status, Pageable pageable);

  List<PayLink> findByStatusAndExpiryAtGreaterThan(PayLinkStatus status, LocalDateTime currentTime);

  List<PayLink> findByStatusAndExpiryAtLessThan(PayLinkStatus status, LocalDateTime currentTime);

  List<PayLink> findAllByStatus(PayLinkStatus status);
}
