package com.biapay.core.repository;

import com.biapay.core.model.MerchantSubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantSubUserRepository extends JpaRepository<MerchantSubUser, Long> {

  MerchantSubUser findBySubUser_UserId(Long userId);
}
