package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantSubscriptionAttempt;
import com.biapay.core.model.enums.PaymentStatus;
import com.biapay.core.model.enums.PlanPurchaseStatus;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantSubscriptionAttemptRepository extends JpaRepository<MerchantSubscriptionAttempt,Long> {
    List<MerchantSubscriptionAttempt> findAllByPaymentStatusAndClientTransactionIdIsNullOrderByCreatedAtAsc(PaymentStatus paymentStatus);
    List<MerchantSubscriptionAttempt> findAllByPaymentStatusAndClientTransactionIdIsNullOrderByCreatedAtDesc(PaymentStatus paymentStatus);

    List<MerchantSubscriptionAttempt> findAllByPaymentStatusAndClientTransactionIdIsNotNullOrderByCreatedAtAsc(PaymentStatus paymentStatus);
    List<MerchantSubscriptionAttempt> findAllByPaymentStatusAndClientTransactionIdIsNotNullOrderByCreatedAtDesc(PaymentStatus paymentStatus);

    List<MerchantSubscriptionAttempt> findAllByPaymentStatusAndMerchantAndPlanPurchaseStatusAndSubscriptionPlanId(PaymentStatus paymentStatus, Merchant merchant, PlanPurchaseStatus planPurchaseStatus, Long id);

    List<MerchantSubscriptionAttempt> findAllByPaymentStatus(PaymentStatus paymentStatus);
    List<MerchantSubscriptionAttempt> findAllByPaymentStatusAndIsTransfer(PaymentStatus paymentStatus,boolean isTransfer);

    long countByPaymentStatusAndMerchantAndPlanPurchaseStatusAndSubscriptionPlanId(
            PaymentStatus paymentStatus,
            Merchant merchant,
            PlanPurchaseStatus planPurchaseStatus,
            Long subscriptionPlanId
    );

    boolean existsBySubscriptionPlanIdAndMerchant(Long subscriptionPlanId, Merchant merchant);


}
