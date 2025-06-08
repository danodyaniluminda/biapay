package com.biapay.core.model;

import com.biapay.core.constant.enums.AccountLimitType;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_limit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountLimit extends AbstractAuditingEntity {

  @Id
  private Long id;

  @Enumerated(EnumType.STRING)
  private AccountLimitType accountLimitType;

  private BigDecimal amount;

  private String currencyCode;

  private String countryCode;
}
