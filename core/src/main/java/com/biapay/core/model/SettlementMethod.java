package com.biapay.core.model;

import com.biapay.core.model.enums.GimacIssuerType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "settlement_method")
@Getter
@Setter
@ToString
public class SettlementMethod extends Auditable<String> {

  @ManyToOne
  @JoinColumn(name = "payment_category_id")
  @NotNull
  PaymentCategory paymentCategory;

  @Column Boolean status = true;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settlement_method_seq")
  @SequenceGenerator(
      name = "settlement_method_seq",
      allocationSize = 1,
      sequenceName = "settlement_method_seq")
  private Long id;

  @Column(name = "name")
  @NotNull
  private String name;

  @Column private String imageName;

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
