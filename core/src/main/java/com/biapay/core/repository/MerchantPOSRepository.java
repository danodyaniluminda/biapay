package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantPOS;
import com.biapay.core.model.MerchantSubscriptionCompleted;
import com.biapay.core.model.Shop;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantPOSRepository extends JpaRepository<MerchantPOS, Long> {
  @Query(
      "select merchantPOS from MerchantPOS merchantPOS "
          + "left join fetch merchantPOS.shop shop "
          + "left join fetch shop.merchant merchant "
          + "where shop.shopId = :shopId and merchant.id = :merchantId")
  List<MerchantPOS> findByShop(@Param("shopId") Long shopId, @Param("merchantId") Long merchantId);

  @Query(
      "select merchantPOS from MerchantPOS merchantPOS "
          + "left join fetch merchantPOS.shop shop "
          + "where shop.shopId = :shopId")
  List<MerchantPOS> findByShopId(@Param("shopId") Long shopId);

  @Query(
      "select count(merchantPOS) from MerchantPOS merchantPOS "
          + "left join merchantPOS.shop shop "
          + "left join shop.merchant merchant "
          + "where merchant.id = :merchantId")
  Long countPOSMerchantByMerchant(@Param("merchantId") Long merchantId);

  @Query(
      "select merchantPOS from MerchantPOS merchantPOS "
          + " left join merchantPOS.shop shop"
          + " left join shop.merchant merchant "
          + " where merchantPOS.id = :posId and merchant.id = :merchantId")
  Optional<MerchantPOS> findByIdAndMerchantId(Long posId, Long merchantId);

  @Query(
      "select merchantPOS from MerchantPOS merchantPOS "
          + " left join merchantPOS.shop shop"
          + " left join shop.merchant merchant "
          + " where merchantPOS.isDefault = true and merchant.id = :merchantId")
  Optional<MerchantPOS> findDefaultPOSByMerchantId(Long merchantId);

  Optional<MerchantPOS> getMerchantPOSByIsDefaultTrueAndShop_Merchant(Merchant merchant);

  Boolean existsByCallbackUrlNotNullAndCallbackUrlContainingAndIdIsNot(
      String callbackUrl, Long currentPOSId);

  Boolean existsByCallbackUrlNotNullAndCallbackUrlContaining(String callbackUrl);

  Boolean existsByNameNotNullAndNameAndIdIsNotAndShop(String name, Long currentPOSId, Shop shop);

  Boolean existsByNameNotNullAndNameAndShop(String name, Shop shop);

  List<MerchantPOS> findAllByShop(Shop shop);

  Optional<MerchantPOS> findByUuid(UUID uuid);

  @Query("FROM MerchantPOS merchantPOS JOIN Shop shop ON merchantPOS.shop = shop WHERE shop.merchant = ?1")
  List<MerchantPOS> findByMerchantId(Long merchantId);



  @Query("SELECT COUNT(m) FROM MerchantPOS m WHERE m.merchantSubscriptionCompleted IS NOT NULL AND m.merchantSubscriptionCompleted.id = :mscId")
  long countByMscId(@Param("mscId") Long mscId);

  @Query("SELECT m.id FROM MerchantPOS m WHERE m.merchantSubscriptionCompleted IS NOT NULL AND m.merchantSubscriptionCompleted.id = :mscId")
  List<Long> findPosIdsByMscId(@Param("mscId") Long mscId);

  List<MerchantPOS> findAllByMerchantSubscriptionCompleted(MerchantSubscriptionCompleted merchantSubscriptionCompleted);

  @Query("SELECT m FROM MerchantPOS m JOIN FETCH m.merchantSubscriptionCompleted WHERE m.id = :posId")
  MerchantPOS findMerchantPOSWithSubscription(@Param("posId") Long posId);

  @Query("SELECT m.id FROM MerchantPOS m WHERE m.shop.shopId = :shopId")
  List<Long> findAllPosIdsByShopId(Long shopId);

}
