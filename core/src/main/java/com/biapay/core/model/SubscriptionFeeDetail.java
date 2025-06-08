package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subscription_fee_detail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionFeeDetail extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscription_fee_detail_seq")
  @SequenceGenerator(
      name = "subscription_fee_detail_seq",
      allocationSize = 1,
      sequenceName = "subscription_fee_detail_seq")
  @Column(name = "id")
  private Long id;

  @Column(name = "setup_fee")
  private BigDecimal setupFee;

  @Column(name = "minimum_use_fee")
  private BigDecimal minimumUseFee;

  @Column(name = "statement_fee")
  private BigDecimal statementFee;

  @Column(name = "discount_rate_fee")
  private BigDecimal discountRateFee;

  @Column(name = "batch_fee")
  private BigDecimal batchFee;

  @Column(name = "add_on_modules_fee")
  private BigDecimal addonModulesFee;

  @Column(name = "transaction_fee")
  private BigDecimal transactionFee;

  @Column(name = "gateway_fee")
  private BigDecimal gatewayFee;

  @Column(name = "gateway_fee_mtn")
  private BigDecimal mtnGatewayFee;

  @Column(name = "gateway_fee_orange")
  private BigDecimal orangeGatewayFee;

  @Column(name = "gateway_fee_eumomo")
  private BigDecimal euMomoGatewayFee;
}
