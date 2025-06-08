package com.biapay.core.repository;

import com.biapay.core.model.Country;
import com.biapay.core.model.CustomerData;
import com.biapay.core.model.profile.MobileOperator;
import com.biapay.core.model.user.UserMobileAccount;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMobileAccountRepository extends JpaRepository<UserMobileAccount, Long> {
  Optional<List<UserMobileAccount>> findByOperatorAndCountryAndPhoneNumber(
      MobileOperator operator, Country country, String phoneNumber);

  Optional<List<UserMobileAccount>> findByCustomerData(CustomerData customerData);
}
