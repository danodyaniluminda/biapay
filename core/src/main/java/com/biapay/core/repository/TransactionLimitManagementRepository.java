package com.biapay.core.repository;

import com.biapay.core.model.TransactionLimitManagement;
import com.biapay.core.model.UserStatus;
import com.biapay.core.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionLimitManagementRepository
    extends JpaRepository<TransactionLimitManagement, Long> {

  boolean existsByCurrency_IdAndSubscriptionPlan_IdAndUserStatusAndUserTypeAndIdIsNot(
      Long currency_id,
      Long subscriptionPlan_id,
      UserStatus userStatus,
      UserType userType,
      Long id);

  boolean existsByCurrency_IdAndUserStatusAndUserTypeAndIdIsNotAndSubscriptionPlanIsNull(
      Long currency_id, UserStatus userStatus, UserType userType, Long id);

  TransactionLimitManagement findByCurrency_CodeAndSubscriptionPlan_IdAndUserStatusAndUserType(
      String currency_code, Long subscriptionPlan_id, UserStatus userStatus, UserType userType);

  TransactionLimitManagement findByCurrency_CodeAndUserStatusAndUserType(
      String currency_code, UserStatus userStatus, UserType userType);
}
