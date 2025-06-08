package com.biapay.core.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "payout_service_balance")
@Getter
@Setter
@ToString
public class PayoutServiceBalance {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "currency")
  private String currency;

  @Column(name = "balance")
  private BigDecimal balance;

  @ManyToOne
  @JoinColumn(name = "payout_service_id")
  private PayoutService payoutService;
}
