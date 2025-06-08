package com.biapay.core.repository;

import com.biapay.core.model.SubscriptionPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPaymentRepository
    extends CrudRepository<SubscriptionPayment, Integer> {}
