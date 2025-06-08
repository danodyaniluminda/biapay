package com.biapay.core.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "settlement_default_ranges")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SettlementDefaultRange extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long currencyId;

  @Column(name = "settlement_limit_x")
  private BigDecimal settlementLimitX;

  @Column(name = "settlement_limit_y")
  private BigDecimal settlementLimitY;
}
