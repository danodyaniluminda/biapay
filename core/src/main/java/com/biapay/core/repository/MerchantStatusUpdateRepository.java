package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantStatusUpdate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantStatusUpdateRepository extends CrudRepository<MerchantStatusUpdate, Long> {
  Optional<List<MerchantStatusUpdate>> findByMerchant(Merchant merchant);
}
