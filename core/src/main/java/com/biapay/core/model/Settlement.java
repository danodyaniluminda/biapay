package com.biapay.core.model;

import com.biapay.core.constant.enums.TransactionFeePayer;
import com.biapay.core.model.enums.SettlementStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "settlement")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Settlement extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settlement_seq")
  @SequenceGenerator(name = "settlement_seq", allocationSize = 1, sequenceName = "settlement_seq")
  @Column(name = "id")
  private Long id;

  private UUID clientTransactionId;

  private String settlementPeriodType; // subscription plan - real time, T+1, T+2 etc.

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDate settlementDate;

  private Long merchantPosId;

  private BigDecimal settlementAmount;

  private String settlementCurrency;

  private UUID settlementTransactionId;

  private Long paymentMethodId;

  private String paymentCategory; // TODO: need to check this

  private Long approvedBy;
  private Long secondApprovedBy;

  @Enumerated(EnumType.STRING)
  private SettlementStatus status;

  @Column(name = "init_status")
  @Enumerated(EnumType.STRING)
  private SettlementStatus initStatus;

  private String remarks;

  private BigDecimal fees;
  private BigDecimal tax;
  @Column(name = "operational_fees")
  private BigDecimal operationalFees;

  @Column(name = "fee_payer")
  @Enumerated(EnumType.STRING)
  private TransactionFeePayer transactionFeePayer;

  @Column(name = "group_id")
  private UUID groupId;

  private BigDecimal initialAmount;
  private BigDecimal totalAmount;
  @Column(name = "initial_settlement_amount")
  private BigDecimal initialSettlementAmount;

  @Column(name = "initial_biapay_settlement_account")
  private Long initialSettlementAccount;

  @Column(name = "settlement_ref")
  private UUID settlementRef;

  @Column(name = "transaction_type")
  private String transactionType;

  @Column(name = "settlement_method_id")
  private Long settlementMethodId;
}
