package com.biapay.core.repository;

import com.biapay.core.model.profile.ProfileBank;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileBankRepository extends CrudRepository<ProfileBank, Long> {
  Optional<ProfileBank> findByBankCode(String bankCode);
}
