package com.biapay.core.repository;

import com.biapay.core.model.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

  List<Address> findByMerchantId(Long merchantId);
}
