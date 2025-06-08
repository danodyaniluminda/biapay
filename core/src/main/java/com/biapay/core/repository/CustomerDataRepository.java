package com.biapay.core.repository;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.model.CustomerData;
import com.biapay.core.model.User;
import com.biapay.core.model.UserStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDataRepository extends JpaRepository<CustomerData, Long> {

  CustomerData findByEmail(String email);

  CustomerData findByPhoneNo(Long phone);

  CustomerData findByWalletAddress(String walletAddress);

  Optional<List<CustomerData>> findByUserStatus(UserStatus userStatus);

  Optional<List<CustomerData>> findByKycApprovalStatus(KycApprovalStatus kycApprovalStatus);

  Optional<CustomerData> findByUser(User user);

  Optional<CustomerData> findByUserUserId(Long userId);

  Optional<CustomerData> findByUuid(UUID uuid);

  // 2024-11-06
  List<CustomerData> findAllByEmail(String email);
  List<CustomerData> findAllByPhoneNo(Long phone);
  boolean existsByPhoneNo(Long phone);
  boolean existsByEmail(String email);
}
