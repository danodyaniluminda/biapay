package com.biapay.core.repository;

import com.biapay.core.model.Workday;
import com.biapay.core.model.WorkdayId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkdayRepository extends JpaRepository<Workday, WorkdayId> {}
