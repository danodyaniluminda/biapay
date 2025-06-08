package com.biapay.core.model;

import com.biapay.core.constant.enums.TransactionFeePayer;
import com.biapay.core.model.enums.SettlementStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "settlement_final_transactions")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SettlementFinalTransaction extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settlement_final_transactions_seq")
  @SequenceGenerator(name = "settlement_final_transactions_seq", allocationSize = 1, sequenceName = "settlement_final_transactions_seq")
  @Column(name = "id")
  private Long id;

  private Long settlementId;
  private UUID settlementRef;
  private UUID clientTransactionId;

  private Long merchantId;
  private Long merchantPosId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDate transactionDate;

  private Long paymentMethodId;
  private String transactionCurrency;
  private BigDecimal transactionInitialAmount;
  private BigDecimal transactionTotalAmount;
  private BigDecimal exchangeRate;

  private BigDecimal initialSettlementAmount;
  private BigDecimal totalSettlementAmount;
  private BigDecimal unpaidBillingAmount;
  private BigDecimal merchantAccountBalance;
  private BigDecimal operationalFees;
  private BigDecimal transactionFees;
  private BigDecimal tax;
  private Long finalSettlementAmount;

  private String settlementPeriodType; // subscription plan - real time, T+1, T+2 etc.
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDate settlementDate;
  private Long settlementMethodId;
  private String settlementCurrency;
  private UUID settlementTransactionId;
  private String paymentCategory;

  @Column(name = "fee_payer")
  @Enumerated(EnumType.STRING)
  private TransactionFeePayer transactionFeePayer;
  private UUID groupId;

  @Column(name = "final_biapay_settlement_account")
  private Long finalSettlementAccount;

  @Enumerated(EnumType.STRING)
  private SettlementStatus status;

  @Column(name = "init_status")
  @Enumerated(EnumType.STRING)
  private SettlementStatus initStatus;
  private String remarks;

  private String approvedBy;
  private LocalDateTime approvedAt;
  private LocalDateTime completedAt;
  private LocalDateTime failedAt;
}
