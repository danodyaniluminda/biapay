package com.biapay.core.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "assignment")
public class Assignment extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assignment_seq")
  @SequenceGenerator(name = "assignment_seq", allocationSize = 1, sequenceName = "assignment_seq")
  Long id;

  @ManyToOne Shop shop;

  @ManyToOne User user;

  @Enumerated(EnumType.STRING)
  ShopEntitlementGroup entitlementGroup;
}
