package com.biapay.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "payment_service_pos")
@Getter
@Setter
@ToString
public class PaymentTransactionPos {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "pos_id")
  private String posId;
  @Column(name = "pos_name")
  private String posName;
  @Column(name = "client_id")
  private String clientId;
  @Column(name = "client_secret")
  private String clientSecret;
}
