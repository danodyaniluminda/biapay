package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

@Entity
@Table(name = "transaction_limit")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Deprecated
public class TransactionLimit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "sending_daily")
  private BigDecimal sendingDaily;

  @Column(name = "sending_weekly")
  private BigDecimal sendingWeekly;

  @Column(name = "sending_monthly")
  private BigDecimal sendingMonthly;

  @Column(name = "receiving_daily")
  private BigDecimal receivingDaily;

  @Column(name = "receiving_weekly")
  private BigDecimal receivingWeekly;

  @Column(name = "receiving_monthly")
  private BigDecimal receivingMonthly;

  @ManyToOne
  @JoinColumn(name = "currency_id")
  private Currency currency;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "subscription_plan_id")
  @ToString.Exclude
  @JsonIgnore
  private SubscriptionPlan subscriptionPlan;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    TransactionLimit that = (TransactionLimit) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
