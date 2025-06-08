package com.biapay.core.model;

import com.biapay.core.model.enums.LoyaltyBillStatus;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "loyalty_bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class LoyaltyBill {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
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

  @Column(name = "sub_total", precision = 19, scale = 2)
  private double subTotal;

  @Column(name = "tax_total", precision = 19, scale = 2)
  private double taxTotal;

  @Column(name = "discount_total", precision = 19, scale = 2)
  private double discountTotal;

  @Column(name = "amount", precision = 19, scale = 2)
  private double amount;

  @Column(name = "paid", precision = 19, scale = 2)
  private double paid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_loyalty_activities_id")
  @ToString.Exclude
  private UserLoyaltyActivity userLoyaltyActivity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "currency_id")
  @ToString.Exclude
  private Currency currency;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @ToString.Exclude
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "super_merchant_id")
  @ToString.Exclude
  private Merchant superMerchant;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pos_id")
  @ToString.Exclude
  private MerchantPOS pos;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "shop_id")
  @ToString.Exclude
  private Shop shop;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "paylink_id")
  @ToString.Exclude
  private PayLink paylink;

  @Column(name = "paylink_uuid")
  private String paylinkUuid;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private LoyaltyBillStatus status;

  @Column(name = "payment_method_id")
  private Long paymentMethodId;
}
