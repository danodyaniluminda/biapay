package com.biapay.core.repository;

import com.biapay.core.model.Currency;
import com.biapay.core.model.SubscriptionPlan;
import java.util.List;
import java.util.Optional;
import javax.persistence.Tuple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPlanRepository extends CrudRepository<SubscriptionPlan, Long> {

  SubscriptionPlan findBysubscriptionName(String subscriptionPlanName);

  @Query(value = "select * from subscription_plan where subscription_id = ?", nativeQuery = true)
  SubscriptionPlan getPlanBasedonId(SubscriptionPlan subscriptionPlan);

  @Query(
      value = "select * from subscription_plan where subscription_name = ?1 and flag = true",
      nativeQuery = true)
  SubscriptionPlan getPlanByname(String name);

  boolean existsSubscriptionPlanBySubscriptionName(String name);

  List<SubscriptionPlan> findByFlag(Boolean val);

  @Deprecated
  Optional<List<SubscriptionPlan>> findByDefaultPlan(boolean defaultPlan);

  Optional<List<SubscriptionPlan>> findByFeatured(boolean featuredPlan);

  Optional<List<SubscriptionPlan>> findAllByCurrenciesIsContaining(Currency currency);

  @Query("from SubscriptionPlan where defaultPlan = TRUE")
  List<SubscriptionPlan> findDefaultPlan();

  Optional<SubscriptionPlan> findFirstByFlagIsTrueAndDefaultPlanIsTrue();

  @Query(
      value =
          "select COALESCE(sum(max_sub_users), 0) as max_sub_users, COALESCE(sum(max_listed_products), 0) as max_listed_products, COALESCE(sum(max_pos_per_shop),0) as max_pos_per_shop, COALESCE(sum(max_published_events),0) as max_published_events, COALESCE(sum(max_shops),0) as max_shops,COALESCE((select count(*) from merchant_shop_user where merchant_shop_id in (select shop_id from merchant_shop where merchant_id = :merchantId))) as availed_sub_users,COALESCE((select count(id) from invoice_product where merchant_id = :merchantId and is_listed_in_store = true)) as availed_listed_products, COALESCE((select count(id)from merchant_pos left join merchant_shop on merchant_pos.shop_id = merchant_shop.shop_id where merchant_shop.merchant_id = :merchantId)) as availed_pos_per_shop,(select count(id) from event left join \"user\" u on cast(event.user_id as bigint) = u.user_id where u.merchant_id = :merchantId) as availed_events, (select count(shop_id) from merchant_shop where merchant_id = :merchantId) as availed_shops from subscription_plan sp left join merchant_subscription ms on sp.id = ms.subscription_plan_id where merchant_id = :merchantId",
      nativeQuery = true)
  Tuple getSubscriptionLimitDetails(@Param("merchantId") long merchantId);

  Optional<SubscriptionPlan> findFirstBySubscriptionNameIgnoreCase(String subscriptionName);
}
