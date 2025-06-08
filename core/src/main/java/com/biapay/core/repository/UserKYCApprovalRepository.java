package com.biapay.core.repository;

import com.biapay.core.model.user.UserKYC;
import com.biapay.core.model.user.UserKYCApproval;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserKYCApprovalRepository extends JpaRepository<UserKYCApproval, Long> {

  Optional<UserKYCApproval> findFirstByUserKYCOrderByDateDesc(UserKYC userKYC);
}
