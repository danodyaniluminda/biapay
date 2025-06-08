package com.biapay.core.model;

import com.biapay.core.model.enums.LoyaltyType;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "loyalty")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Loyalty extends Auditable<String> {

  @NotNull private String name;

  @NotNull
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "campaign_id")
  private Campaign campaign;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loyalty_id_seq")
  @SequenceGenerator(name = "loyalty_id_seq", sequenceName = "loyalty_id_seq_gen")
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "benefit_type")
  @Enumerated(EnumType.STRING)
  private LoyaltyType benefitType;

  @NotNull
  @Column(name = "amount_type")
  @Enumerated(EnumType.STRING)
  private AmountType amountType; // amount could be cash-back or point

  @Column(name = "fixed_amount")
  private BigDecimal fixedAmount; // cash-back,point

  @Column(name = "percentage")
  private BigDecimal percentage;

  @NotNull
  @Column(name = "max_amount_per_customer")
  private Integer maxAmountPerCustomer;

  @NotNull
  @Column(name = "max_amount_per_merchant")
  private Integer maxAmountPerMerchant;

  public enum AmountType {
    PERCENTAGE,
    TOTAL
  }
}
