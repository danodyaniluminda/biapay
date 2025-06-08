package com.biapay.core.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name = "workday")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Workday extends Auditable<String> {
  @EmbeddedId private WorkdayId id;
  private Boolean isHoliday;
}
