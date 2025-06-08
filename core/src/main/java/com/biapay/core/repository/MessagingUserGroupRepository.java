package com.biapay.core.repository;

import com.biapay.core.model.MessagingUserGroup;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagingUserGroupRepository extends JpaRepository<MessagingUserGroup, Long> {

  List<MessagingUserGroup> findAllByStatus(String status);

  MessagingUserGroup findByName(String groupId);
}
