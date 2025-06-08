package com.biapay.core.model;

import com.biapay.core.constant.enums.AccountStatus;
import com.biapay.core.model.enums.AccountSubType;
import com.biapay.core.model.enums.AccountType;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Account extends AbstractAuditingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accounts_account_id_seq")
  @SequenceGenerator(
      name = "accounts_account_id_seq",
      allocationSize = 1,
      sequenceName = "accounts_account_id_seq")
  private Long accountId;

  @Column(name = "account_user_id")
  private Long accountUserId;
  @Column(name = "account_number")
  private String accountNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "account_user_type")
  private UserType accountUserType;

  @Column(name = "currency_code")
  private String currencyCode;

  @Column(name = "balance")
  private BigDecimal balance = BigDecimal.ZERO;

  @Column(name = "on_hold")
  private BigDecimal onHold = BigDecimal.ZERO;

  @Column(name = "account_type")
  @Enumerated(EnumType.STRING)
  private AccountType accountType;

  @Column(name = "account_sub_type")
  @Enumerated(EnumType.STRING)
  private AccountSubType accountSubType;

  @Column(name = "account_status")
  @Enumerated(EnumType.STRING)
  private AccountStatus accountStatus;

  @Column(name = "settlement_method_id")
  private Long settlementMethodId;

  @Column(name = "payment_method_id")
  private Long paymentMethodId;

  @Column(name = "pos_id")
  private Long posId;

  @Column(name = "account_number_type")
  @Enumerated(EnumType.STRING)
  private AccountNumberTypeEnum accountNumberType;

  @Version
  @Column(name = "version")
  private Long version;
}
