package com.biapay.core.model;

import com.biapay.core.constant.enums.InvoicePeriod;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bill_item")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
public class BillItem {
  private static final long serialVersionUID = 1005L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "bill_id", nullable = false)
  private Bill bill;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "subscription_plan_id", nullable = false)
  private SubscriptionPlan subscriptionPlan;

  @Column(name = "subscription_days")
  private int subscriptionDays;

  @Column(name = "start_date")
  private LocalDateTime startDate;

  @Column(name = "end_date")
  private LocalDateTime endDate;

  @Column(name = "invoice_period")
  @Enumerated(EnumType.STRING)
  private InvoicePeriod invoicePeriod;

  @Column(name = "billing_terms")
  private int billingTerms;

  @Column(name = "auto_renew")
  private boolean autoRenew;

  @Column(name = "price")
  private Double price;

  @Column(name = "total")
  private Double totalAmount;
}
