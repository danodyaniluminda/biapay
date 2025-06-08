package com.biapay.core.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paypal_order")
public class PaypalOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paypal_order_seq")
  @SequenceGenerator(
      name = "paypal_order_seq",
      allocationSize = 1,
      sequenceName = "paypal_order_seq")
  private Long id;

  @Column private String order_id;

  @Column private LocalDateTime created_at;

  @Enumerated(EnumType.STRING)
  private PaypalOrderStatus status;

  @Column private String approveLink;

  @Column private String captureLink;

  @Column private String payerActionLink;

  @ManyToOne
  @JoinColumn(name = "client_transaction_id")
  private ClientTransaction clientTransaction;
}
