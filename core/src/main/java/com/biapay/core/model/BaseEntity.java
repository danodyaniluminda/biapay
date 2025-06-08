package com.biapay.core.model;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
  private LocalDateTime createdAt;

  private LocalDateTime lastUpdatedAt;

  private String createdBy;

  private String lastUpdatedBy;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    lastUpdatedAt = LocalDateTime.now();
  }
}
