package com.biapay.core.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "business_type")
@Getter
@Setter
public class BusinessType extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_type_seq")
  @SequenceGenerator(
      name = "business_type_seq",
      allocationSize = 1,
      sequenceName = "business_type_seq")
  private Long businessTypeId;

  @Column @NotNull private String name;
  @Column private String description;

  @ManyToOne
  @JoinColumn(name = "industry_industry_id", nullable = true)
  private Industry industry;
}
