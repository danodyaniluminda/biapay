package com.biapay.core.repository;


import com.biapay.core.model.Merchant;
import com.biapay.core.model.PosSubscriptionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosSubscriptionHistoryRepository extends JpaRepository<PosSubscriptionHistory,Long> {

    PosSubscriptionHistory findTopByMerchantOrderByCreatedAtDesc(Merchant merchant);
    List<PosSubscriptionHistory> findAllByMerchant(Merchant merchant);
    boolean existsByMerchant(Merchant merchant);

    @Query("SELECT COUNT(p) > 0 FROM PosSubscriptionHistory p WHERE p.merchant.id = :merchantId")
    boolean existsByMerchantId(@Param("merchantId") Long merchantId);

    PosSubscriptionHistory findFirstByPosIdOrderByCreatedAtDesc(Long posId);

    @Query("SELECT DISTINCT p.posId FROM PosSubscriptionHistory p")
    List<Long> findAllUniquePosIds();

    @Query("SELECT DISTINCT p.newMscId FROM PosSubscriptionHistory p")
    List<Long> findAllUniqueNewMscIds();

    List<PosSubscriptionHistory> findAllByNewMscId(Long id);

    @Query("SELECT DISTINCT p.posId FROM PosSubscriptionHistory p WHERE p.newMscId = :newMscId")
    List<Long> findUniquePosIdsByNewMscId(@Param("newMscId") Long newMscId);






}
