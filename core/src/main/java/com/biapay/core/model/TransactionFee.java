package com.biapay.core.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "transaction_fee")
public class TransactionFee extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_fee_seq")
  @SequenceGenerator(
      name = "transaction_fee_seq",
      allocationSize = 1,
      sequenceName = "transaction_fee_seq")
  private Long id;

  @Column(name = "lower_bound")
  @NotNull
  private Long lowerBound;

  @Column(name = "upper_bound")
  @NotNull
  private Long upperBound;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "percent")
  private Float percent;

  @Column(name = "amount_and_percent")
  private String both;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "payment_method_id")
  @ToString.Exclude
  private PaymentMethod method;

  @ManyToOne
  @NotNull
  @ToString.Exclude
  @NotFound(action = NotFoundAction.IGNORE)
  private SubscriptionPlan subscriptionPlan;

  @JoinColumn(name = "method_subtype")
  private String methodSubtype;

  @ManyToOne @NotNull private Currency currency;

  @Transient private String name;
}
