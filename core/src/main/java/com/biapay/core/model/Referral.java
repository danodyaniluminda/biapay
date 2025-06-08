package com.biapay.core.model;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "referral")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Referral {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "min_amount")
  private BigDecimal minAmount;

  @ManyToOne
  @JoinColumn(name = "currency_id")
  private Currency currency;

  @Column(name = "reward")
  private int reward;

  @Column(name = "active")
  private boolean active;
}
