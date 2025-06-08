package com.biapay.core.repository;

import com.biapay.core.model.PayoutService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayoutServiceRepository extends JpaRepository<PayoutService, Long> {

}
