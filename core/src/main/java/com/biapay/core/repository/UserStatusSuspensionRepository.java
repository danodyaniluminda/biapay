package com.biapay.core.repository;

import com.biapay.core.model.User;
import com.biapay.core.model.UserStatusSuspension;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusSuspensionRepository extends CrudRepository<UserStatusSuspension, Long> {
  @Query(
      value =
          "from UserStatusSuspension mrst where mrst.user= :user and mrst.changeDate BETWEEN :startDate AND :endDate")
  Page<UserStatusSuspension> findByUserAndChangeDate(
      User user, Date startDate, Date endDate, Pageable pageable);

  @Query(
      value =
          "from UserStatusSuspension mrst where mrst.changeDate BETWEEN :startDate AND :endDate")
  Page<UserStatusSuspension> findAllByChangeDateBetween(
      Date startDate, Date endDate, Pageable pageable);
}
