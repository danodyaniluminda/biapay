package com.biapay.core.repository;

import com.biapay.core.model.AccessHistory;
import com.biapay.core.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccessHistoryRepository extends JpaRepository<AccessHistory, Long> {

  @Query(
      "select accessHistory from AccessHistory accessHistory"
          + " left join fetch accessHistory.user user"
          + " where user.userId = :userId order by accessHistory.createdDate desc")
  List<AccessHistory> findByUserId(Long userId);

  @Query("select a from AccessHistory a order by a.id desc")
  List<AccessHistory> findAllrecord();

  AccessHistory findFirstByUserOrderByLastModifiedDateDesc(User user);
}
