package com.biapay.core.repository;

import com.biapay.core.constant.enums.AccountLimitType;
import com.biapay.core.model.AccountLimit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountLimitRepository extends JpaRepository<AccountLimit, Long> {

  List<AccountLimit> findAllByAccountLimitType(AccountLimitType accountLimitType);
}
