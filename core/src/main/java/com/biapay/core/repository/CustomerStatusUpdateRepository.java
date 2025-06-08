package com.biapay.core.repository;

import com.biapay.core.model.user.CustomerStatusUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerStatusUpdateRepository extends JpaRepository<CustomerStatusUpdate, Long> {}
