package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.TrialSubscription;
import org.springframework.data.repository.CrudRepository;

public interface TrialSubscriptionRepository extends CrudRepository<TrialSubscription, Long> {

  public TrialSubscription findByMerchant(Merchant email);
}
