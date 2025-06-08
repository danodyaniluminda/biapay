package com.biapay.core.model;

import com.biapay.core.constant.enums.TransactionFeeType;
import com.biapay.core.model.enums.GimacIssuerType;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "payment_method")
@Getter
@Setter
@ToString
public class PaymentMethod extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_method_seq")
  @SequenceGenerator(
      name = "payment_method_seq",
      allocationSize = 1,
      sequenceName = "payment_method_seq")
  private Long id;

  @Column(name = "name")
  @NotNull
  private String name;

  @Column(name = "associated_fee_status")
  private String associatedFeeStatus;

  @Column private TransactionFeeType feeType;

  @ManyToOne
  @JoinColumn(name = "payment_category_id")
  @NotNull
  PaymentCategory paymentCategory;

  @Column Boolean status = true;

  @Column private String imageName;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "payment_method_currencies",
      joinColumns = @JoinColumn(name = "payment_method_id"),
      inverseJoinColumns = @JoinColumn(name = "currency_id"))
  @ToString.Exclude
  private Set<Currency> currencies;

  @Column(name = "country_id")
  private Long countryId;

  @Column(name="gimac_issuer_code")
  private String gimacIssuerCode;

  @Column(name="gimac_issuer_type")
  @Enumerated(EnumType.STRING)
  private GimacIssuerType gimacIssuerType;

  @Column(name = "is_gimacpay")
  private Boolean isGimacpay;

}
