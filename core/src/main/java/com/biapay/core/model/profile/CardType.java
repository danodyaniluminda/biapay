package com.biapay.core.model.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "card_type")
public class CardType {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_type_seq")
  @SequenceGenerator(name = "card_type_seq", allocationSize = 1, sequenceName = "card_type_seq")
  private Long card_type_id;

  @NotNull
  @Column(unique = true)
  private String cardTypeName;
}
