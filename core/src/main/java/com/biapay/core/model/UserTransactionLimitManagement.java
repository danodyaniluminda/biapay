package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_transaction_limit_management")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class UserTransactionLimitManagement {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
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
  @JoinColumn(name = "user_id")
  private User user;
}
