package com.biapay.core.model;

import com.biapay.core.model.enums.AccountEventType;
import com.biapay.core.model.enums.AccountType;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountEvent extends AbstractAuditingEntity {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "account_event_account_event_id_seq")
  @SequenceGenerator(
      name = "account_event_account_event_id_seq",
      allocationSize = 1,
      sequenceName = "account_event_account_event_id_seq")
  private Long accountEventId;

  @Column(name = "account_id")
  private Long accountId;

  @ManyToOne
  @JoinColumn(name = "account_id", updatable = false, insertable = false)
  private Account account;

  @Column(name = "account_transaction_id")
  private Long accountTransactionId;

  @ManyToOne
  @JoinColumn(name = "account_transaction_id", updatable = false, insertable = false)
  private AccountTransaction accountTransaction;

  private BigDecimal amount;

  private BigDecimal balanceBeforeTransaction;

  private BigDecimal balanceAfterTransaction;

  @Enumerated(EnumType.STRING)
  private AccountEventType eventType;

  @Enumerated(EnumType.STRING)
  private AccountType accountType;
}
