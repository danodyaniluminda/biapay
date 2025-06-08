package com.biapay.core.repository;

import com.biapay.core.model.Country;
import com.biapay.core.model.Merchant;
import com.biapay.core.model.profile.MobileAccount;
import com.biapay.core.model.profile.MobileOperator;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface MobileAccountRepository extends CrudRepository<MobileAccount, Long> {
  Optional<List<MobileAccount>> findByOperatorAndCountryAndPhoneNumber(
      MobileOperator operator, Country country, String phoneNumber);

  Optional<List<MobileAccount>> findByMerchant(Merchant merchant);
}
