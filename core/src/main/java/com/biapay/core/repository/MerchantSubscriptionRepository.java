package com.biapay.core.repository;

import com.biapay.core.model.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantSubscriptionRepository
    extends JpaRepository<MerchantSubscription, Integer> {

  MerchantSubscription findByMerchant(Merchant merchant);

  Optional<List<MerchantSubscription>> findAllByMerchant(Merchant merchant);

  Optional<MerchantSubscription> findByMerchantPOS(MerchantPOS merchantPOS);

  @Query(
      "select merchantSubscription from MerchantSubscription merchantSubscription"
          + " left join fetch merchantSubscription.subscriptionPlan subscriptionPlan "
          + " left join fetch subscriptionPlan.paymentMethods paymentMethods "
          + " left join fetch paymentMethods.paymentCategory "
          + " left join fetch merchantSubscription.merchantPOS merchantPOS "
          + " left join fetch merchantPOS.shop shop "
          + " left join fetch shop.merchant merchant "
          + " where merchantSubscription.subscriptionStatus='Active'"
          + " and merchantPOS.id = :merchantPOSId")
  MerchantSubscription findByMerchantPOSId(@Param("merchantPOSId") Long merchantPOSId);

  MerchantSubscription findMerchantSubscriptionByMerchantPOS_IdAndSubscriptionStatusEqualsIgnoreCase(Long merchantPOSId, String status);

  List<MerchantSubscription> findBySubscriptionStatus(String status);

  @Query(value = "select count(*) cn from biapay.merchant_subscription_completed "+
          " where is_test_plan = false and end_date > current_date", nativeQuery = true)
  int countSubscriptionByType();

  Optional<List<MerchantSubscription>> findAllBySubscriptionPlan(SubscriptionPlan subscriptionPlan);
  Optional<List<MerchantSubscription>> findAllBySubscriptionPlanAndMerchant(SubscriptionPlan subscriptionPlan, Merchant merchant);

  List<MerchantSubscription> findAllBySubscriptionEndDateIsGreaterThanEqualAndSubscriptionStatus(
      Date subscriptionEndDate, String status);

  Optional<MerchantSubscription> getFirstByMerchantPOSOrderByCreatedDateDesc(MerchantPOS merchantPOS);
}
