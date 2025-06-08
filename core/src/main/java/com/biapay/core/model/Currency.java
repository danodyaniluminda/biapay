package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Builder
@Getter
@Setter
@Table(name = "currency")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE currency SET deleted = true where id=?")
@Where(clause = "deleted = false")
public class Currency extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_seq")
  @SequenceGenerator(name = "currency_seq", allocationSize = 1, sequenceName = "currency_seq")
  private Long id;

  @Column(name = "uuid", unique = true)
  private UUID uuid;

  @Column(name = "name", unique = true)
  private String name;

  @Column(name = "code", unique = true)
  private String code;

  @Column(name = "display")
  private String display;

  @Column(name = "symbol")
  private String symbol;

  @Column(name = "rate")
  private BigDecimal rate;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "is_default")
  private Boolean isDefault;

  @Column(name = "deleted")
  private Boolean deleted = Boolean.FALSE;
}
