package com.biapay.core.repository;

import com.biapay.core.model.UserTransactionLimit;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionLimitRepository extends JpaRepository<UserTransactionLimit, Long> {

  List<UserTransactionLimit>
      findAllByUser_UserIdAndTransactionLimitManagement_IdAndCreatedAtBetween(
          Long user_userId,
          Long transactionLimitManagement_id,
          Timestamp createdAt,
          Timestamp createdAt2);
    List<UserTransactionLimit> findAllByUser_UserIdAndCreatedAtBetween(Long user_userId, Timestamp createdAt, Timestamp createdAt2);

    List<UserTransactionLimit> findAllByUser_UserIdInAndCreatedAtBetween(List<Long> userIds, Timestamp createdAt, Timestamp createdAt2);

    List<UserTransactionLimit>
    findAllByUser_UserIdAndUserTransactionLimitManagement_IdAndCreatedAtBetween(
            Long user_userId,
            Long userTransactionLimitManagement_id,
            Timestamp createdAt,
            Timestamp createdAt2);
}
