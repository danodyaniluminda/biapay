package com.biapay.core.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "industry")
@Getter
@Setter
public class Industry extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "industry_seq")
  @SequenceGenerator(name = "industry_seq", allocationSize = 1, sequenceName = "industry_seq")
  private Long industryId;

  @Column @NotNull private String name;
  @Column private String description;
}
