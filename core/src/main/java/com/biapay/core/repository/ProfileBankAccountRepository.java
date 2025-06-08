package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.profile.BankAccount;
import com.biapay.core.model.profile.Branch;
import com.biapay.core.model.profile.ProfileBank;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileBankAccountRepository extends CrudRepository<BankAccount, Long> {
  Optional<List<BankAccount>> findByProfileBankAndBranchAndNumberAndCode(
      ProfileBank profileBank, Branch branch, Long number, Long code);

  Optional<List<BankAccount>> findByMerchant(Merchant merchant);
}
