package com.biapay.core.repository;

import com.biapay.core.model.CustomerData;
import com.biapay.core.model.profile.Branch;
import com.biapay.core.model.profile.ProfileBank;
import com.biapay.core.model.user.UserBankAccount;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBankAccountRepository extends JpaRepository<UserBankAccount, Long> {
  Optional<List<UserBankAccount>> findByProfileBankAndBranchAndNumberAndCode(
      ProfileBank profileBank, Branch branch, Long number, Long code);

  Optional<List<UserBankAccount>> findByCustomerData(CustomerData customerData);
}
