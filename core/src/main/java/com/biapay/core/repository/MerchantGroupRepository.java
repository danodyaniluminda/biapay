package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantGroup;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantGroupRepository extends JpaRepository<MerchantGroup, Long> {

  List<MerchantGroup> findByMerchants(Merchant merchant);
}
