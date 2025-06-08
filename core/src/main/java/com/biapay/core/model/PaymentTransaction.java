package com.biapay.core.model;

import com.biapay.core.model.enums.PaymentTransactionStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "payment_transaction")
@Getter
@Setter
@ToString
public class PaymentTransaction {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "order_id")
  private String orderId;

  @ManyToOne
  @JoinColumn(name = "payment_service_id")
  private ThirdPartyPaymentService service;

  @Column(name = "external_service_id")
  private String mavianceServiceId;

  @Column(name = "external_service_item_id")
  private String mavianceServiceItemId;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "fee")
  private BigDecimal fee;

  @Column(name = "user_type")
  @Enumerated(EnumType.STRING)
  private UserType userType;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "currency_code")
  private String currency;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private PaymentTransactionStatus status;

  @Column(name = "beneficiary_number")
  private String beneficiaryNumber;
}
