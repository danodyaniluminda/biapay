package com.biapay.core.model;

import com.biapay.core.constant.ClientTransactionStatus;
import com.biapay.core.constant.InvoiceType;
import com.biapay.core.constant.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "client_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Where(clause = "is_test = false")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClientTransaction extends Auditable<String> {
  // this is a unique transaction ID
  @Id private UUID id;

  // This is the merchant pos related to the transaction
  // Notice that a Pos is related to a shop
  @ManyToOne
  @JoinColumn(name = "merchant_pos_id")
  @ToString.Exclude
  private MerchantPOS merchantPOS;

  private Long customerDataId;

  private String clientId;

  private String clientUserEmail;

  private String clientUserMobile;

  private String clientUserName;

  private String orderId;

  private BigDecimal orderAmount;

  private String orderCurrency;

  private BigDecimal originalOrderAmount;

  private String originalOrderCurrency;

  private String clientTransactionId;

  private String clientTokenId;

  @Enumerated(EnumType.STRING)
  private ClientTransactionStatus status;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDateTime initiatedAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDateTime completedAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
  private LocalDateTime failedAt;

  private BigDecimal transactionFee = BigDecimal.ZERO;

  @ManyToOne
  @JoinColumn(name = "payment_method_id")
  private PaymentMethod paymentMethod;

  @ManyToOne
  @JoinColumn(name = "subscription_plan_id")
  @ToString.Exclude
  private SubscriptionPlan subscriptionPlan;

  private String lang;

  @Column private boolean qrcode = false;

  private LocalDateTime settledAt;

  private LocalDate settlementDate;

  private BigDecimal exchangeRate;

  private BigDecimal totalAmount;

  private String externalReference;

  @ManyToOne
  @JoinColumn(name = "batch_job_execution_id")
  private BatchJobExecution batchJobExecution;

  @Column
  @Enumerated(EnumType.STRING)
  private InvoiceType invoiceType = InvoiceType.INVOICE;

  @ManyToOne
  @JoinColumn(name = "paylink_id")
  @ToString.Exclude
  private PayLink payLink;

  @Column(name = "transaction_type")
  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;

  @Column(name = "payment_type")
  @Enumerated(EnumType.STRING)
  private PaymentType paymentType;

  @Column(name = "is_test")
  private boolean isTest;

  @Column(name = "client_fee_amount")
  private BigDecimal clientFeeAmount;

  @Column(name = "merchant_fee_amount")
  private BigDecimal merchantFeeAmount;

  @Column(name = "logged_user_id")
  private String loggedUserId;

  @Column(name = "logged_username")
  private String loggedUsername;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ClientTransaction that = (ClientTransaction) o;
    return Objects.equals(id, that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
