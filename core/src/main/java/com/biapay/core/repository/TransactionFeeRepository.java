package com.biapay.core.repository;

import com.biapay.core.model.Currency;
import com.biapay.core.model.PaymentMethod;
import com.biapay.core.model.SubscriptionPlan;
import com.biapay.core.model.TransactionFee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionFeeRepository extends JpaRepository<TransactionFee, Long> {

  List<TransactionFee> findByMethod(PaymentMethod method);

  List<TransactionFee> findByMethodSubtype(String methodSubtype);

  Optional<List<TransactionFee>> findByMethodAndSubscriptionPlan(
      PaymentMethod method, SubscriptionPlan plan);

  @Deprecated
  List<TransactionFee> findByMethodAndSubscriptionPlanAndCurrency(
      PaymentMethod method, SubscriptionPlan plan, Currency currencies);

  Optional<List<TransactionFee>> findAllByCurrency(Currency currency);

  @Query(
      "select transactionFee from TransactionFee transactionFee "
          + " join fetch transactionFee.subscriptionPlan subscriptionPlan "
          + " join fetch transactionFee.method paymentMethod "
          + " join fetch transactionFee.currency currency "
          + " where subscriptionPlan.id = :subscriptionPlanId "
          + " and paymentMethod.id = :paymentMethodId "
          + " and currency.id = :currencyId ")
  List<TransactionFee> findByMethodAndSubscriptionPlanAndCurrency(
      Long paymentMethodId, Long subscriptionPlanId, Long currencyId);

  List<TransactionFee> findAllByMethod_IdAndSubscriptionPlan_IdAndCurrency_Id(
      Long paymentMethodId, Long subscriptionId, Long currencyId);
}
