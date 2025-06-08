package com.biapay.core.repository;

import com.biapay.core.model.PaypalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaypalOrderRepository extends JpaRepository<PaypalOrder, Long> {}
