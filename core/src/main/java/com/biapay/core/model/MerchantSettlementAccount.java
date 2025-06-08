package com.biapay.core.model;

import java.io.Serializable;
import java.math.BigDecimal;import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "merchant_settlement_acc")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(MerchantSettlementAccount.MerchantSettlementAccountId.class)
public class MerchantSettlementAccount extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_settlement_acc_seq")
  @SequenceGenerator(
      name = "merchant_settlement_acc_seq",
      allocationSize = 1,
      sequenceName = "merchant_settlement_acc_seq")
  private Long id;

  @NotNull private Long merchantPosId;

  @NotNull private Long paymentMethodId;

  private String paymentAccountAddress;

  @Column(name = "is_default")
  private Boolean defaultAcc;

  @Column(name = "percentage")
  private BigDecimal percentage;

//  @Data
//  @NoArgsConstructor
//  @AllArgsConstructor
//  public static class MerchantSettlementAccountId implements Serializable {
//    private Long merchantPosId;
//    private Long paymentMethodId;
//  }
}
