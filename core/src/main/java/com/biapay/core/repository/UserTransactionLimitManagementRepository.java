package com.biapay.core.repository;

import com.biapay.core.model.UserTransactionLimitManagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserTransactionLimitManagementRepository
    extends JpaRepository<UserTransactionLimitManagement, Long> {


  List<UserTransactionLimitManagement> findAllByUser_userId(Long user_userId);

  boolean existsByCurrency_IdAndUser_userIdAndIdIsNot(
      Long currency_id,
      Long userId,
      Long id);

  Optional<UserTransactionLimitManagement> findByCurrency_CodeAndUser_userId(String currency_code, Long user_userId);

  boolean existsByUser_userId(Long user_userId);

}
