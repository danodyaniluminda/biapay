package com.biapay.core.repository;

import com.biapay.core.constant.ClientTransactionStatus;
import com.biapay.core.dto.dashboard.DashBoardItem;
import com.biapay.core.dto.dashboard.DashBoardItemValue;
import com.biapay.core.model.*;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Repository
public interface ClientTransactionRepository extends JpaRepository<ClientTransaction, UUID> {

  @Query(value = "select * from client_transactions where id = :id", nativeQuery = true)
  Optional<ClientTransaction> findById(UUID id);


  @Query(
      "select clientTransaction from ClientTransaction clientTransaction"
          + " join fetch clientTransaction.paymentMethod"
          + " where clientTransaction.id = :id")
  ClientTransaction findByIdWithPaymentMethod(UUID id);

  ClientTransaction findByClientIdAndClientTransactionId(
      String clientId, String clientTransactionId);

  List<ClientTransaction> findByClientId(String merchantId);

  Optional<ClientTransaction> findByExternalReference(String externalReference);

  List<ClientTransaction> findByClientIdAndOrderCurrencyAndStatusAndCompletedAtBetween(
      String clientId,
      String orderCurrency,
      ClientTransactionStatus status,
      LocalDateTime from,
      LocalDateTime to);

  List<ClientTransaction> findByOrderCurrencyAndStatusAndCompletedAtBetween(
      String orderCurrency, ClientTransactionStatus status, LocalDateTime from, LocalDateTime to);

  List<ClientTransaction> findByClientIdAndOrderCurrencyAndInitiatedAtBetween(
      String clientId, String orderCurrency, LocalDateTime from, LocalDateTime to);

  List<ClientTransaction> findByOrderCurrencyAndInitiatedAtBetween(
      String orderCurrency, LocalDateTime from, LocalDateTime to);

  List<ClientTransaction> findByInitiatedAtBetween(LocalDateTime from, LocalDateTime to);

  List<ClientTransaction> findByCustomerDataIdAndOrderCurrencyAndStatusAndCompletedAtBetween(
      Long customerDataId,
      String orderCurrency,
      ClientTransactionStatus status,
      LocalDateTime from,
      LocalDateTime to);

  List<ClientTransaction> findByCustomerDataId(Long customerDataId);

  List<ClientTransaction> findByCustomerDataIdAndStatus(
      Long customerDataId, ClientTransactionStatus status);

  List<ClientTransaction> findByCustomerDataIdAndOrderCurrencyAndInitiatedAtBetween(
      Long customerDataId, String orderCurrency, LocalDateTime from, LocalDateTime to);

  List<ClientTransaction> findByCustomerDataIdAndInitiatedAtBetween(
      Long customerDataId, LocalDateTime from, LocalDateTime to);

  @Query(value = "SELECT * FROM client_transactions WHERE paylink_id = :payLinkId "
      + "ORDER BY created_at DESC LIMIT 1", nativeQuery = true)
  Optional<ClientTransaction> findFirstByPayLinkId(@Param("payLinkId") Long payLinkId);

  List<ClientTransaction> findAllByPayLinkOrderByCreatedDateDesc(PayLink payLink);

  @Query(
      "select clientTransaction from ClientTransaction clientTransaction "
          + " left join fetch clientTransaction.merchantPOS merchantPOS "
          + " where merchantPOS.id = :merchantPOSId and clientTransaction.isTest = false")
  List<ClientTransaction> findByMerchantPOSId(Long merchantPOSId);

  @Query(
      "select clientTransaction from ClientTransaction clientTransaction "
          + "left join fetch clientTransaction.merchantPOS merchantPOS "
          + "where merchantPOS.shop.merchant.id = :merchantId "
          + "and clientTransaction.orderCurrency = :currency "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt > :from "
          + "and clientTransaction.initiatedAt < :to")
  List<ClientTransaction> findByMerchantCurrencyStatusFromAndToDate(
      Long merchantId, String currency, LocalDateTime from, LocalDateTime to);

  @Query(
      "select clientTransaction from ClientTransaction clientTransaction "
          + " left join fetch clientTransaction.merchantPOS merchantPOS "
          + " where merchantPOS.id = :merchantPOSId "
          + "and clientTransaction.orderCurrency = :currency "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt > :from "
          + "and clientTransaction.initiatedAt < :to")
  List<ClientTransaction> findByPOSCurrencyFromAndToDate(
      Long merchantPOSId, String currency, LocalDateTime from, LocalDateTime to);

  @Query(
      "select clientTransaction from ClientTransaction clientTransaction "
          + " left join fetch clientTransaction.merchantPOS merchantPOS "
          + " where merchantPOS.id = :merchantPOSId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt > :from "
          + "and clientTransaction.initiatedAt < :to")
  List<ClientTransaction> findByFromAndToDate(
      Long merchantPOSId, LocalDateTime from, LocalDateTime to);

  @Query(
      "from ClientTransaction clientTransaction "
          + " left join fetch clientTransaction.subscriptionPlan"
          + " left join fetch clientTransaction.paymentMethod paymentMethod"
          + " left join fetch paymentMethod.paymentCategory paymentCategory"
          + " where clientTransaction.id = :id and clientTransaction.isTest = false")
  ClientTransaction findByUUID(UUID id);

  @Query(
      "from ClientTransaction clientTransaction "
          + " left join fetch clientTransaction.subscriptionPlan"
          + " left join fetch clientTransaction.paymentMethod paymentMethod"
          + " left join fetch paymentMethod.paymentCategory paymentCategory"
          + " where clientTransaction.id = :id and clientTransaction.isTest = false")
  ClientTransaction findFirstByUUIDOOrderByCreatedDateCreatedDateDesc(UUID id);

  @Query(
      "from ClientTransaction clientTransaction "
          + " left join fetch clientTransaction.subscriptionPlan"
          + " left join fetch clientTransaction.paymentMethod paymentMethod"
          + " left join fetch paymentMethod.paymentCategory paymentCategory"
          + " where clientTransaction.settlementDate = :settlementDate and clientTransaction.isTest = false")
  List<ClientTransaction> findBySettlementDate(LocalDate settlementDate);

  Optional<List<ClientTransaction>> findAllByOrderCurrencyOrOriginalOrderCurrency(
      String orderCurrency, String originalOrderCurrency);

  List<ClientTransaction>
      findTop10ByMerchantPOS_Shop_MerchantAndStatusInAndOrderCurrencyOrderByCompletedAtDesc(
          Merchant merchant, List<ClientTransactionStatus> statuses, String currency);

  List<ClientTransaction>
  findTop20ByMerchantPOS_Shop_MerchantAndStatusInAndOrderCurrencyOrderByCompletedAtDesc(
          Merchant merchant, List<ClientTransactionStatus> statuses, String currency);

  // new merchant dashboard - start
  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItem(clientTransaction.orderCurrency, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS merchantPOS "
          + "left join  merchantPOS.shop shop "
          + "where shop.shopId = :shopId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "Group by clientTransaction.orderCurrency")
  List<DashBoardItem> findByShopFromAndToDateForGivingStatuses(
      Long shopId, LocalDateTime from, LocalDateTime to, List<ClientTransactionStatus> statuses);

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItemValue(pos.id, pos.name, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "left join  pos.shop shop "
          + "where shop.shopId = :shopId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "and clientTransaction.orderCurrency = :currency "
          + "Group by pos.id "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItemValue> findByGivingShopAndCurrencyOnAPeriodGroupingByPos(
      Long shopId,
      String currency,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItemValue(category.id, category.name, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "left join  pos.shop shop "
          + "left join  clientTransaction.paymentMethod method "
          + "left join  method.paymentCategory category "
          + "where shop.shopId = :shopId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "and clientTransaction.orderCurrency = :currency "
          + "Group by category.id "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItemValue> findByGivingShopAndCurrencyOnAPeriodGroupingByPaymentCategory(
      Long shopId,
      String currency,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItemValue(method.id, method.name, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "left join  pos.shop shop "
          + "left join  clientTransaction.paymentMethod method "
          + "where shop.shopId = :shopId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "and clientTransaction.orderCurrency = :currency "
          + "Group by method.id "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItemValue> findByGivingShopAndCurrencyOnAPeriodGroupingByPaymentMethod(
      Long shopId,
      String currency,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  @Query(
      "select clientTransaction.orderCurrency "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "left join  pos.shop shop "
          + "where shop.shopId = :shopId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "Group by clientTransaction.orderCurrency ")
  List<String> findUsedCurrencyOnAPeriod(
      Long shopId, LocalDateTime from, LocalDateTime to, List<ClientTransactionStatus> statuses);

  @Query(
      "select clientTransaction.orderCurrency "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "left join  pos.shop shop "
          + "left join  shop.merchant merchant "
          + "where merchant.id = :merchantId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "Group by clientTransaction.orderCurrency ")
  List<String> findUsedCurrencyOnAPeriodForAMerchant(
      Long merchantId,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  @Query(
      "select clientTransaction.orderCurrency "
          + " from ClientTransaction clientTransaction "
          + "where clientTransaction.customerDataId = :customerDataId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "Group by clientTransaction.orderCurrency ")
  List<String> findUsedCurrencyOnAPeriodForACustomer(
      Long customerDataId,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  // for merchant pos stat

  @Query(
      "select clientTransaction.orderCurrency "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "where pos.id = :posId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "Group by clientTransaction.orderCurrency ")
  List<String> findUsedCurrencyOnAPeriodByPos(
      Long posId, LocalDateTime from, LocalDateTime to, List<ClientTransactionStatus> statuses);

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItem(clientTransaction.orderCurrency, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS merchantPOS "
          + "where merchantPOS.id = :posId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "Group by clientTransaction.orderCurrency")
  List<DashBoardItem> findByPosFromAndToDateForGivingStatuses(
      Long posId, LocalDateTime from, LocalDateTime to, List<ClientTransactionStatus> statuses);

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItemValue(category.id, category.name, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "left join  clientTransaction.paymentMethod method "
          + "left join  method.paymentCategory category "
          + "where pos.id = :posId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "and clientTransaction.orderCurrency = :currency "
          + "Group by category.id "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItemValue> findByGivingPosAndCurrencyOnAPeriodGroupingByPaymentCategory(
      Long posId,
      String currency,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItemValue(method.id, method.name, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "left join  clientTransaction.paymentMethod method "
          + "where pos.id = :posId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "and clientTransaction.orderCurrency = :currency "
          + "Group by method.id "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItemValue> findByGivingPosAndCurrencyOnAPeriodGroupingByPaymentMethod(
      Long posId,
      String currency,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  // for merchant shops stats
  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItemValue(shop.shopId, shop.name, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "left join  pos.shop shop "
          + "left join  shop.merchant merchant "
          + "where merchant.id = :merchantId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "and clientTransaction.orderCurrency = :currency "
          + "Group by shop.shopId "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItemValue> findByGivingMerchantAndCurrencyOnAPeriodGroupingByShop(
      Long merchantId,
      String currency,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  // for simple user stat

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItem(clientTransaction.orderCurrency, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "where clientTransaction.customerDataId = :customerDataId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "group by clientTransaction.orderCurrency "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItem> findByGivingCustomerGroupingByCurrency(
      Long customerDataId,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItemValue(category.id, category.name, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.paymentMethod method "
          + "left join  method.paymentCategory category "
          + "where clientTransaction.customerDataId = :customerDataId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "and clientTransaction.orderCurrency = :currency "
          + "Group by category.id "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItemValue> findByGivingCustomerAndCurrencyOnAPeriodGroupingByPaymentCategory(
      Long customerDataId,
      String currency,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItemValue(method.id, method.name, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.paymentMethod method "
          + "where clientTransaction.customerDataId = :customerDataId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "and clientTransaction.orderCurrency = :currency "
          + "Group by method.id "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItemValue> findByGivingCustomerAndCurrencyOnAPeriodGroupingByPaymentMethod(
      Long customerDataId,
      String currency,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  @Query(
      "select new com.biapay.core.dto.dashboard.DashBoardItemValue(shop.shopId, shop.name, SUM(clientTransaction.orderAmount), count(clientTransaction.id)) "
          + " from ClientTransaction clientTransaction "
          + "left join  clientTransaction.merchantPOS pos "
          + "left join  pos.shop shop "
          + "left join  shop.merchant merchant "
          + "where clientTransaction.customerDataId = :customerDataId "
          + "and clientTransaction.isTest = false "
          + "and clientTransaction.initiatedAt >= :from "
          + "and clientTransaction.initiatedAt <= :to "
          + "and clientTransaction.status in :statuses "
          + "and clientTransaction.orderCurrency = :currency "
          + "Group by shop.shopId "
          + "order by sum(clientTransaction.orderAmount) desc")
  List<DashBoardItemValue> findByGivingCustomerAndCurrencyOnAPeriodGroupingByShop(
      Long customerDataId,
      String currency,
      LocalDateTime from,
      LocalDateTime to,
      List<ClientTransactionStatus> statuses);

  // new merchant dashboard - end
  @Query(value = "SELECT * FROM client_transactions WHERE client_token_id = :id AND client_transaction_id = :clientTransactionId", nativeQuery = true)
  Optional<ClientTransaction> findByClientTokenIdAndClientTransactionId(String id, String clientTransactionId);

  @Query(value = "SELECT * FROM client_transactions WHERE completed_at BETWEEN :startDate "
      + "AND :endDate AND status = :status", nativeQuery = true)
  List<ClientTransaction> findAllByCompletedAtBetweenAndStatus(
      @Param("startDate") LocalDateTime completedAt,
      @Param("endDate") LocalDateTime completedAt2,
      @Param("status") String status);

  @Query(value = "SELECT * FROM client_transactions WHERE completed_at BETWEEN :startDate "
      + "AND :endDate AND status = :status AND subscription_plan_id = :subscriptionPlanId",
      nativeQuery = true)
  List<ClientTransaction> findAllByCompletedAtBetweenAndStatusAndSubscriptionPlan_Id(
      @Param("startDate") LocalDateTime completedAt,
      @Param("endDate") LocalDateTime completedAt2,
      @Param("status") String status,
      @Param("subscriptionPlanId") Long subscriptionPlan_id);

  @Query(value = "SELECT * FROM client_transactions " +
      "WHERE client_user_email IN (:emails)", nativeQuery = true)
  List<ClientTransaction> findAllByClientUserEmailIn(@Param("emails") List<String> emails);

  @Query("SELECT SUM(totalAmount) from ClientTransaction where payLink=:payLink and isTest = false")
  BigDecimal sumPartiallyPaidAmount(PayLink payLink);

  // queries to retrieve test transactions only. Keep it at the bottom

  @Query(value = "select * from client_transactions "
                  + " where order_currency = :currency "
                  + " and is_test = true "
                  + " and initiated_at > :from "
                  + " and initiated_at < :to", nativeQuery = true)
  List<ClientTransaction> findAllTestTransactionsByCurrencyAndInitiatedAtBetween(String currency, LocalDateTime from, LocalDateTime to);

  @Query(value = "select * from client_transactions "
                  + " where is_test = true "
                  + " and initiated_at > :from "
                  + " and initiated_at < :to", nativeQuery = true)
  List<ClientTransaction> findAllTestTransactionsByInitiatedAtBetween(LocalDateTime from, LocalDateTime to);

  @Query(value = "select * from client_transactions ct" +
                  " inner join merchant_pos mp on ct.merchant_pos_id = mp.id" +
                  " inner join merchant_shop ms on mp.shop_id = ms.shop_id" +
                  " where ms.merchant_id = :merchantId" +
                  " and ct.is_test = true" +
                  " and ct.order_currency = :currency" +
                  " and ct.initiated_at > :from" +
                  " and ct.initiated_at < :to", nativeQuery = true)
  List<ClientTransaction> findTx(Long merchantId, String currency, LocalDateTime from, LocalDateTime to);

  @Query(value = "select * from client_transactions ct" +
                  " inner join merchant_pos mp on ct.merchant_pos_id = mp.id" +
                  " inner join merchant_shop ms on mp.shop_id = ms.shop_id" +
                  " where ms.merchant_id = :merchantId" +
                  " and ct.is_test = true" +
                  " and ct.order_currency = :currency" +
                  " and ct.initiated_at > :from" +
                  " and ct.initiated_at < :to", nativeQuery = true)
  List<ClientTransaction> findAllTestTransactionsByMerchantCurrencyAndInitiatedAtBetween(Long merchantId, String currency, LocalDateTime from, LocalDateTime to);

  @Query(value = "select * from client_transactions ct" +
                  " inner join merchant_pos mp on ct.merchant_pos_id = mp.id" +
                  " inner join merchant_shop ms on mp.shop_id = ms.shop_id" +
                  " where ms.merchant_id = :merchantId" +
                  " and ct.is_test = true" +
                  " and ct.initiated_at > :from" +
                  " and ct.initiated_at < :to", nativeQuery = true)
  List<ClientTransaction> findAllTestTransactionsByMerchantAndInitiatedAtBetween(Long merchantId, LocalDateTime from, LocalDateTime to);

  @Query(value = "select * from client_transactions ct" +
                  " inner join merchant_pos mp on ct.merchant_pos_id = mp.id" +
                  " where mp.id = :merchantPOSId" +
                  " and ct.is_test = true" +
                  " and ct.order_currency = :currency" +
                  " and ct.initiated_at > :from" +
                  " and ct.initiated_at < :to", nativeQuery = true)
  List<ClientTransaction> findAllTestTransactionsByPOSCurrencyAndInitiatedAtBetween(Long merchantPOSId, String currency, LocalDateTime from, LocalDateTime to);

  @Query(value = "select * from client_transactions ct" +
                  " inner join merchant_pos mp on ct.merchant_pos_id = mp.id" +
                  " where mp.id = :merchantPOSId" +
                  " and ct.is_test = true" +
                  " and ct.initiated_at > :from" +
                  " and ct.initiated_at < :to", nativeQuery = true)
  List<ClientTransaction> findAllTestTransactionsByPOSAndInitiatedAtBetween(Long merchantPOSId, LocalDateTime from, LocalDateTime to);

  @Query(value = "from ClientTransaction ct"
      + " where ct.orderCurrency = :currency "
      + " and ct.isTest = false "
      + " and ct.transactionType = :transactionType "
      + " and ct.initiatedAt > :from "
      + " and ct.initiatedAt < :to")
  List<ClientTransaction> findAllTransactionsByCurrencyAndTransactionTypeAndInitiatedAtBetween(String currency, TransactionType transactionType, LocalDateTime from, LocalDateTime to);


  List<ClientTransaction> findTop10ByMerchantPOSInAndStatusInAndOrderCurrencyOrderByCompletedAtDesc(
          List<MerchantPOS> merchantPOS, List<ClientTransactionStatus> statuses, String currency);

  @Query(value = "select * from client_transactions where id = :id and status = 'INITIATED'", nativeQuery = true)
  Optional<ClientTransaction> findActiveTransactionById(UUID id);

  Optional<ClientTransaction> findByOrderIdAndStatus(String orderId, ClientTransactionStatus status);
}
