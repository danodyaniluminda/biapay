package com.biapay.core.repository;



import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantSubscriptionCompleted;
import com.biapay.core.model.enums.PlanAcquireMethod;
import com.biapay.core.model.enums.PlanPurchaseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantSubscriptionCompletedRepository extends JpaRepository<MerchantSubscriptionCompleted,Long> {
    List<MerchantSubscriptionCompleted> findAllByMerchant(Merchant merchant);

    List<MerchantSubscriptionCompleted> findAllByIsActive(boolean isActive);

    Optional<MerchantSubscriptionCompleted> findByMsaId(Long id);
    // Derived query method to find all MerchantSubscriptionCompleted by merchant and where endDate is greater than current time
    List<MerchantSubscriptionCompleted> findAllByMerchantAndEndDateGreaterThan(Merchant merchant, LocalDateTime currentDateTime);

    List<MerchantSubscriptionCompleted> findAllByDisplayNameAndMerchantAndSubscriptionPlanIdAndPlanPurchaseStatus(String displayName, Merchant merchant, Long id, PlanPurchaseStatus planPurchaseStatus);
    List<MerchantSubscriptionCompleted> findAllByDisplayNameAndMerchantAndSubscriptionPlanId(String displayName, Merchant merchant, Long id);

    Page<MerchantSubscriptionCompleted> findAllByPlanAcquireMethodAndEndDateGreaterThan(PlanAcquireMethod planAcquireMethod, Pageable pageable, LocalDateTime currentDateTime);
    Page<MerchantSubscriptionCompleted> findAllByMerchant_IdAndPlanAcquireMethodAndEndDateGreaterThan(Long merchantId, PlanAcquireMethod planAcquireMethod, Pageable pageable, LocalDateTime currentDateTime);

    @Query(value = "SELECT * FROM merchant_subscription_completed WHERE merchant_id = :merchantId AND end_date > :givenDate", nativeQuery = true)
    List<MerchantSubscriptionCompleted> findActiveSubscriptionsByMerchantIdAndDate(@Param("merchantId") Long merchantId, @Param("givenDate") LocalDateTime givenDate);

    @Query(value = "SELECT COUNT(*) FROM merchant_subscription_completed WHERE merchant_id = :merchantId AND end_date > :givenDate", nativeQuery = true)
    Long countActiveSubscriptionsByMerchantIdAndDate(@Param("merchantId") Long merchantId, @Param("givenDate") LocalDateTime givenDate);

}
