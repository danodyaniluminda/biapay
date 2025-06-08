package com.biapay.core.repository;

import com.biapay.core.model.User;
import com.biapay.core.model.UserLoyaltyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserLoyaltyGroupRepository extends JpaRepository<UserLoyaltyGroup, Long> {
    @Query(nativeQuery = true, value = "select * from user_loyalty_group inner join user_loyalty_group_mapping ulgm on user_loyalty_group.id = ulgm.user_loyalty_group_id where ulgm.user_id = :userId")
    List<UserLoyaltyGroup> findAllGroupsForUser(@Param("userId") long userId);
}
