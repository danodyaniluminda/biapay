package com.biapay.core.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "payment_transaction_fee")
@Getter
@Setter
@ToString
public class PaymentTransactionFee {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "operation")
  private ThirdPartyPaymentService service;

  @Column(name = "currency_code")
  private String currency;

  @Column(name = "lower_bound")
  private BigDecimal lowerBound;

  @Column(name = "upper_bound")
  private BigDecimal upperBound;

  @Column(name = "fee_structure")
  @Enumerated(EnumType.STRING)
  private FeeStructure feeStructure;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "percent")
  private BigDecimal percent;
}
