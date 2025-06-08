package com.biapay.core.repository;

import com.biapay.core.model.MerchantCredential;
import com.biapay.core.model.MerchantPOS;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantCredentialRepository extends JpaRepository<MerchantCredential, Long> {
  @Query(
      "select merchantPOS from MerchantCredential merchantCredential"
          + " left join merchantCredential.merchantPOS merchantPOS"
          + " where merchantCredential.clientId = :clientId")
  Optional<MerchantPOS> findByClientId(String clientId);

  @Query(
      "select merchantCredential from MerchantCredential merchantCredential "
          + "where merchantCredential.validTill >= :timestamp "
          + "and merchantCredential.merchantPOS.id = :posMerchantId")
  Optional<MerchantCredential> findValidByMerchantPOS(Long posMerchantId, LocalDateTime timestamp);

  @Query(
      "select merchantCredential from MerchantCredential merchantCredential "
          + " left join merchantCredential.merchantPOS merchantPOS"
          + " left join merchantPOS.shop shop "
          + " left join shop.merchant merchant "
          + " left join merchant.rootUser rootUser "
          + " where merchantCredential.clientId = :clientId ")
  MerchantCredential findByMerchantCredentialByClientId(String clientId);

  @Query(
      "select merchantCredential from MerchantCredential merchantCredential "
          + "where merchantCredential.merchantPOS.id = :posMerchantId")
  Optional<MerchantCredential> findByMerchantPOS(Long posMerchantId);

  Optional<MerchantCredential> getMerchantCredentialByMerchantPOS(MerchantPOS merchantPOS);
}
