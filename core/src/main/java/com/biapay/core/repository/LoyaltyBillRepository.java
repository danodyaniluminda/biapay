package com.biapay.core.repository;

import com.biapay.core.model.LoyaltyBill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyBillRepository extends JpaRepository<LoyaltyBill, Long> {

  Optional<LoyaltyBill> findByPaylink_Id(Long paylink_id);
}
