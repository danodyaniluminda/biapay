package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantPOS;
import com.biapay.core.model.Shop;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
  Optional<List<Shop>> findByMerchant(Merchant merchant);

  Optional<Shop> findByName(String name);

  @Query(
      "select shop from Shop shop "
          + "left join fetch shop.merchant merchant "
          + "left join fetch shop.users users "
          + "where merchant.id = :merchantId and shop.shopId = :shopId")
  Optional<Shop> findByShopIdAndMerchantId(
      @Param("merchantId") Long merchantId, @Param("shopId") Long shopId);

  Optional<Shop> findByMerchantPOSListContaining(MerchantPOS merchantPOS);

  @Query(value = "SELECT COUNT(DISTINCT ms.shop_id) " +
      "FROM biapay.merchant_shop ms " +
      "INNER JOIN biapay.merchant_pos mp ON ms.shop_id = mp.shop_id " +
      "INNER JOIN biapay.merchant_subscription_completed msc ON msc.id = mp.msc_id " +
      "WHERE ms.merchant_id = :merchantId " +
      "AND msc.is_active = TRUE " +
      "AND msc.subscription_plan_id = :subscriptionPlanId",
      nativeQuery = true)
  int countDistinctShops(@Param("merchantId") Long merchantId,
      @Param("subscriptionPlanId") Long subscriptionPlanId);

  @Query("SELECT s.shopId FROM Shop s WHERE s.merchant.id = :merchantId")
  List<Long> findAllShopIdsByMerchantId(Long merchantId);
}
