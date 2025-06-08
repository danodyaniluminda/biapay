package com.biapay.core.repository;

import com.biapay.core.model.profile.Branch;
import com.biapay.core.model.profile.ProfileBank;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
  Optional<List<Branch>> findByProfileBank(ProfileBank profileBank);
}
