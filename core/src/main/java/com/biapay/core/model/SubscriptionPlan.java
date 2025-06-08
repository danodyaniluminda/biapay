package com.biapay.core.model;

import com.biapay.core.constant.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "subscription_plan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@ToString
@SQLDelete(sql = "UPDATE subscription_plan SET deleted = true where id=?")
@Where(clause = "deleted = false")
public class SubscriptionPlan extends Auditable<String> {
  public static final String NamedQuery_getSubscriptionLimitDetails = "getsubscriptionlimitdetails";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscription_plan_seq")
  @SequenceGenerator(
      name = "subscription_plan_seq",
      allocationSize = 1,
      sequenceName = "subscription_plan_seq")
  @Column(name = "id")
  private Long id;

  @Column(name = "subscription_name")
  private String subscriptionName;

  @Column(name = "subscription_amount")
  private Double subscriptionAmount;

  @Column(name = "subscription_days")
  private int subscriptionDays;

  @Column(name = "subscription_status")
  private boolean subscriptionStatus;

  @Column(name = "type_of_channels")
  private ChannelType typeofChannels;

  @Column(name = "number_of_transaction")
  private String numberofTransaction;

  @Enumerated(EnumType.STRING)
  private SettlementPeriod settlementPeriod;

  @Enumerated(EnumType.STRING)
  private InvoicePeriod invoicePeriod;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "subscription_plan_payment_method",
      joinColumns = @JoinColumn(name = "subcription_plan_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "payment_method_id", referencedColumnName = "id"))
  private List<PaymentMethod> paymentMethods;

  @Enumerated(EnumType.STRING)
  private PaymentType typeofPayment;

  @Column(name = "shopping_card_allowance")
  private boolean shoppingcardAllowance;

  @Column(name = "ancillaries_allowance")
  private boolean ancillariesAllowance;

  @Column(name = "paymail_link_request")
  private boolean paymaillinkRequest;

  @Column(name = "downgrade_allowable")
  private boolean downgradeAllowable;

  @Column(name = "admin_premission")
  private boolean adminRequest;

  @Column(name = "invoice_payment")
  private boolean invoicePayment;

  @Column(name = "event_management")
  private boolean eventManagement;

  @Column(name = "shopping_cart")
  private boolean shoppingCart;

  @Enumerated(EnumType.STRING)
  private IntegrationType typeofIntegration;

  @ManyToMany @ToString.Exclude private List<Currency> currencies;

  @OneToOne
  @JoinColumn(name = "subscription_fee_id")
  private SubscriptionFeeDetail subscriptionFeeDetail;

  @Column(name = "createrd_date")
  private Date createedDate;

  @Column(name = "updated_date")
  private Date updatedDate;

  @Column(name = "flag")
  private Boolean flag;

  @Column private boolean defaultPlan;

  @Column private Boolean featured = false;

  @Enumerated(EnumType.STRING)
  private SubscriptionPlanType planType;

  @Transient private String downGrade;

  @Enumerated(EnumType.STRING)
  private TransactionFeePayer transactionFeePayer;

  @Column(name = "max_sub_users")
  private Integer maxSubUsers;

  @Column(name = "max_shops")
  private Integer maxShops;

  @Column(name = "max_pos_per_shop")
  private Integer maxPOSPerShop;

  @Column(name = "max_listed_products")
  private Integer maxListedProducts;

  @Column(name = "max_published_events")
  private Integer maxPublishedEvents;

  @OneToMany(mappedBy = "subscriptionPlan", cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<TransactionLimit> transactionLimits;

  @Column(name = "deleted")
  private Boolean deleted = Boolean.FALSE;

  @Column(name = "enable_split_settlement")
  private Boolean enableSplitSettlement;

  @Column(name = "roles_management")
  private Boolean rolesManagement = Boolean.TRUE;
  @Column(name = "settlement")
  private Boolean settlement = Boolean.TRUE;
  @Column(name = "access_history")
  private Boolean accessHistory = Boolean.TRUE;
  @Column(name = "shop_management")
  private Boolean shopManagement = Boolean.TRUE;
  @Column(name = "dashboard")
  private Boolean dashboard = Boolean.TRUE;
  @Column(name = "transactions")
  private Boolean transactions = Boolean.TRUE;
  @Column(name = "loyalty")
  private Boolean loyalty = Boolean.TRUE;
  @Column(name = "referral")
  private Boolean referral = Boolean.TRUE;

  @Column(name = "is_test_plan")
  private Boolean testPlan = Boolean.FALSE;

  @Column(name = "merchant_fee_percentage")
  private BigDecimal merchantFeePercentage;

}
