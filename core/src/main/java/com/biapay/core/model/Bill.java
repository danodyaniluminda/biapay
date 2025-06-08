package com.biapay.core.model;

import com.biapay.core.model.enums.BillStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@Table(name = "bill")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
public class Bill implements Serializable {
  private static final long serialVersionUID = 1004L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "uuid")
  private String uuid;

  @Column(name = "order_no")
  private String orderNo;

  @Column(name = "invoice_no")
  private String invoiceNo;

  @Column(name = "description")
  private String description;

  @Column(name = "invoice_date")
  private LocalDateTime invoiceDate;

  @Column(name = "payment_date")
  private LocalDateTime paymentDate;

  @Column(name = "sub_total")
  private Double subTotal;

  @Column(name = "tax_total")
  private Double taxTotal;

  @Column(name = "discount_total")
  private Double discountTotal;

  @Column(name = "amount")
  private Double billAmount;

  @Column(name = "paid")
  private Double paidAmount;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "currency_id", nullable = false)
  private Currency currency;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "customer_id", nullable = false)
  private Merchant customer;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "super_merchant_id", nullable = false)
  private Merchant merchant;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "pos_id", nullable = false)
  private MerchantPOS merchantPOS;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "shop_id", nullable = false)
  private Shop shop;

  @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<BillItem> billingItems;

  @Column(name = "paylink_id")
  private Long paylinkId;

  @Column(name = "paylink_uuid")
  private String paylinkUuid;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "payment_method_id", nullable = true)
  private PaymentMethod paymentMethod;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private BillStatus status;
}
