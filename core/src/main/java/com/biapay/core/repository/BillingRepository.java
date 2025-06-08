package com.biapay.core.repository;

import com.biapay.core.model.Bill;
import com.biapay.core.model.Merchant;
import com.biapay.core.model.SubscriptionPlan;
import com.biapay.core.model.enums.BillStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillingRepository extends JpaRepository<Bill, Long> {
  List<Bill> findByMerchant(Merchant merchant);

  List<Bill> findByCustomer(Merchant merchant);

  @Query(
      value =
          "from Bill bl left join BillItem bi on bl = bi.bill where bi.subscriptionPlan =:subscriptionPlan and bl.customer =:merchant and bl.status=:status ")
  Optional<Bill> findByCustomerAndSubscriptionPlanAndStatus(
      Merchant merchant, SubscriptionPlan subscriptionPlan, BillStatus status);

  @Query(
      value =
          "from Bill bl left join BillItem bi on bl = bi.bill where bi.subscriptionPlan =:subscriptionPlan and bl.customer =:merchant")
  List<Bill> findByCustomerAndSubscriptionPlan(
      Merchant merchant, SubscriptionPlan subscriptionPlan);

  Optional<Bill> findByCustomerAndId(Merchant merchant, Long id);

  Optional<Bill> findByUuid(String uuid);

  Optional<Bill> findByPaylinkId(Long paylinkId);

  List<Bill> findAllByStatus(BillStatus status);

  Bill findByCustomerOrderByIdDesc(Merchant merchant);
}
