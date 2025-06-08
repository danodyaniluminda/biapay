package com.biapay.core.repository;

import com.biapay.core.constant.enums.AdminGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminGroupRepository extends JpaRepository<AdminGroup, Long> {}
