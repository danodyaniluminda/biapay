package com.biapay.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "settlement_range")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@IdClass(SettlementRange.SettlementRangeId.class)
public class SettlementRange extends Auditable<String> {

  @Id private Long merchantPosId;

  @Id private String currency;

  @Column(name = "settlement_limit_x")
  private BigDecimal settlementLimitX;

  @Column(name = "settlement_limit_y")
  private BigDecimal settlementLimitY;

  @Column(name = "is_default")
  private Boolean isDefault;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class SettlementRangeId implements Serializable {
    private Long merchantPosId;
    private String currency;
  }
}
