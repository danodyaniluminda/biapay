package com.biapay.core.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.*;

@Embeddable
@Setter
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class WorkdayId implements Serializable {
  private Integer date;
  private Integer month;
  private Integer year;
}
