package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.profile.MerchantProfile;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface MerchantProfileRepository extends CrudRepository<MerchantProfile, Long> {
  Optional<MerchantProfile> findByMerchant(Merchant merchant);
}
