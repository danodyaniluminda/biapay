package com.biapay.core.model;

import com.biapay.core.constant.InvoiceType;
import com.biapay.core.constant.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "pay_link")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PayLink extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private UUID uuid;

  @ManyToOne
  @JoinColumn(name = "merchant_id")
  private Merchant merchant;

  @ManyToOne
  @JoinColumn(name = "pos_id")
  private MerchantPOS merchantPOS;

  @Column private String mobileNumber;

  @Column private String customerName;

  @Column private String email;

  @Column private BigDecimal amount;

  @Column private String currency;

  @Column private String message;

  @Column
  @Enumerated(EnumType.STRING)
  private PayLinkStatus status;

  @Column
  @Enumerated(EnumType.STRING)
  private InvoiceType invoiceType = InvoiceType.INVOICE;

  @Column(name = "expiry_at")
  private LocalDateTime expiryAt;

  @Column(name = "payment_type")
  @Enumerated(EnumType.STRING)
  private PaymentType paymentType;

  @Column(name = "partial_amount")
  private BigDecimal partialAmount;

  @Transient private BigDecimal remainingAmount;

  @Column(name = "transaction_type")
  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;

  @Column(name = "payment_amount")
  private BigDecimal paymentAmount;

  @Column(name = "notified_at")
  private LocalDateTime notifiedAt;
}
