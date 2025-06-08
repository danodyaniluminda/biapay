package com.biapay.core.model;

import com.biapay.core.model.enums.BusinessLegalStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "business_detail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@ToString
public class BusinessDetails extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_detail_seq")
  @SequenceGenerator(
      name = "business_detail_seq",
      allocationSize = 1,
      sequenceName = "business_detail_seq")
  private Long id;

  @Column(name = "nameoforganization")
  private String nameoforganization;

  @Column(name = "registereddate")
  private String registereddate;

  @Column(name = "categories")
  private String categories;

  @Column(name = "websitelink")
  private String websitelink;

  @Column(name = "traderegisternumber")
  private String traderegisternumber;

  @Column(name = "taxpayernumber")
  private String taxpayernumber;

  @Column(name = "companyregisterproof")
  private String companyregisterproof;

  @Column(name = "taxationofficeaddressproof")
  private String taxationofficeaddressproof;

  @Column(name = "legal_status")
  @Enumerated(EnumType.STRING)
  @Getter
  @Setter
  private BusinessLegalStatus legalStatus;

  @Column(name = "national_court_competent")
  private String nationalCourtCompetent;

  // additional fields to complete workflow
  @ManyToOne
  @JoinColumn(name = "business_type_business_type_id", nullable = true)
  private BusinessType businessType;
  // additional fields to complete workflow

  @Transient private String docType;
  @Transient private String companyRegProofContentType;
  @Transient private String taxOfficeAddressProofContentType;

  public BusinessType getBusinessType() {
    return businessType;
  }

  public String getDocType() {
    return docType;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }

  public String getNameoforganization() {
    return nameoforganization;
  }

  public void setNameoforganization(String nameoforganization) {
    this.nameoforganization = nameoforganization;
  }

  public String getRegistereddate() {
    return registereddate;
  }

  public void setRegistereddate(String registereddate) {
    this.registereddate = registereddate;
  }

  public String getCategories() {
    return categories;
  }

  public void setCategories(String categories) {
    this.categories = categories;
  }
}
