package com.biapay.core.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "defaultWorkday",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "dayOfWeek",
          columnNames = {"dayOfWeek"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DefaultWorkday extends Auditable<String> {
  @Enumerated(EnumType.STRING)
  @Id
  private DayOfWeek dayOfWeek;

  private Boolean isWorkday;
}
