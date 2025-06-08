package com.biapay.core.repository;

import com.biapay.core.constant.enums.AdminGroup;
import com.biapay.core.model.AdminUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<AdminUser, Long> {
  AdminUser findByEmail(String userName);

  @Query("select admin from AdminUser admin " + "where :group MEMBER OF admin.adminGroup")
  List<AdminUser> findAdminByGroup(AdminGroup group);
}
