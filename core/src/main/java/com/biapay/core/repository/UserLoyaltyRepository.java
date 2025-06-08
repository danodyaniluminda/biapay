package com.biapay.core.repository;

import com.biapay.core.model.UserLoyalty;
import com.biapay.core.model.enums.LoyaltyType;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserLoyaltyRepository extends JpaRepository<UserLoyalty, Long> {

  @Query(
      nativeQuery = true,
      value = "select user_id from user_loyalty where loyalty_campaign_id = :campaign_id")
  List<Long> findUserIdsByCampaignId(@Param("campaign_id") Long campaign_id);

  List<UserLoyalty> findAllByUser_userIdAndBenefitTypeAndExpiresAtGreaterThanEqualOrderByExpiresAt(
      Long user_userId, LoyaltyType benefitType, Timestamp expiresAt);

  List<UserLoyalty> findAllByUser_UserIdAndBenefitTypeAndExpiresAtAfter(Long user_userId, LoyaltyType benefitType, Timestamp expiresAt);
}
