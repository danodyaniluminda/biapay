package com.biapay.core.repository;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.model.CustomerData;
import com.biapay.core.model.user.UserKYC;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserKYCRepository extends JpaRepository<UserKYC, Long> {
  UserKYC findByCustomerData(CustomerData customerData);

  Optional<UserKYC> findByIdAndEmailid(Long id, String email);

  List<UserKYC> findByKycApprovalStatus(KycApprovalStatus status);
}
