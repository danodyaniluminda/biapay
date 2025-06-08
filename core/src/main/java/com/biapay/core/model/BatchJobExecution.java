package com.biapay.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "batch_job_execution")
@Getter
@Setter
public class BatchJobExecution extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_job_execution_id_seq")
  @SequenceGenerator(
      name = "batch_job_execution_id_seq",
      allocationSize = 1,
      sequenceName = "batch_job_execution_id_seq")
  private Long id;

  private String jobName;
  private LocalDateTime executedAt;
  private LocalDate settlementDate;

  @Enumerated(EnumType.STRING)
  private BatchJobExecutionStatus status;
}
