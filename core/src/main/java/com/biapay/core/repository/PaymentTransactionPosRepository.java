package com.biapay.core.repository;

import com.biapay.core.model.PaymentTransactionPos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransactionPosRepository extends JpaRepository<PaymentTransactionPos, Long> {

}
