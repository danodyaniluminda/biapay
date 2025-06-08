package com.biapay.core.repository;

import com.biapay.core.model.BatchJobExecution;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BatchJobExecutionRepository extends JpaRepository<BatchJobExecution, Long> {
  @Query(
      value = "select count(*) from batch_job_execution where settlement_date = current_date",
      nativeQuery = true)
  int countBySettlementDate();

  @Query(value = "select current_date", nativeQuery = true)
  LocalDate getCurrentDate();
}
