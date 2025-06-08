package com.biapay.core.model;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.PayLink;
import com.biapay.core.model.SubscriptionPlan;
import com.biapay.core.model.enums.ConfortBillingStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;
import javax.persistence.Id;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "confort_billing")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
public class ConfortBilling implements Serializable {
  private static final long serialVersionUID = 1000L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "merchant_id", nullable = false)
  @ToString.Exclude
  private Merchant merchant;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "paylink_uuid", nullable = false)
  @ToString.Exclude
  private PayLink payLink;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "subscription_plan_id", nullable = false)
  @ToString.Exclude
  private SubscriptionPlan subscriptionPlan;

  @Column(name = "settlement_amount")
  private BigDecimal settlementAmount;

  @Column(name = "plan_amount")
  private BigDecimal planAmount;

  @Column(name = "paid_amount")
  private BigDecimal paidAmount;

  @Column(name = "settlement_date")
  private LocalDate settlementDate;

  @Column(name = "settlement_transaction_id")
  private UUID settlementTransactionId;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "paid_at")
  private LocalDateTime paidAt;

  @Column(name = "invoice_date")
  private LocalDate invoiceDate;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private ConfortBillingStatus status;
}
