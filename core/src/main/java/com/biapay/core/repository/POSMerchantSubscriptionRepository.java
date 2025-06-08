package com.biapay.core.repository;

import com.biapay.core.model.POSMerchantSubscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POSMerchantSubscriptionRepository
    extends CrudRepository<POSMerchantSubscription, Long> {}
