package com.biapay.core.model;

import com.biapay.core.constant.enums.SettlementTransactionStatus;
import com.biapay.core.constant.enums.TransactionFeePayer;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "settlement_transaction")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SettlementTransaction extends Auditable<String> {

  @Id private UUID id;

  private Long merchantPosId;

  private BigDecimal billingAmount;
  private BigDecimal settlementAmount;
  private BigDecimal disbursementAmount;

  private String settlementCurrency;

  @Enumerated(EnumType.STRING)
  private SettlementTransactionStatus status;

  //  private String transactionChannel;
  //
  //  private String typeOfIntegration;

  @ManyToOne
  @JoinColumn(name = "payment_method_id")
  private PaymentMethod transactionPaymentMethod;

  @ManyToOne
  @JoinColumn(name = "settlement_payment_method_id")
  private SettlementMethod settlementPaymentMethod;

  //  private String paymentCategory;

  private String paymentAccountAddress;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDateTime initiatedAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDateTime completedAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDateTime failedAt;

  private String remarks;

  private BigDecimal fees;

  @Column(name = "fee_payer")
  @Enumerated(EnumType.STRING)
  private TransactionFeePayer transactionFeePayer;

  private String settlementAccount;
  private String disbursementAccount;

  @Column(name = "group_id")
  private UUID groupId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDate settlementDate;
}
