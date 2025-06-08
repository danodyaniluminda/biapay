package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "identity_information")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
public class IdentityInformation extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identity_information_seq")
  @SequenceGenerator(
      name = "identity_information_seq",
      allocationSize = 1,
      sequenceName = "identity_information_seq")
  private Long id;

  @Column(name = "identification")
  private String identification;

  @Column(name = "number")
  private String number;

  @Column(name = "dateofdelivery")
  private String dateofdelivery;

  @Column(name = "stateofdelivery")
  private String stateofdelivery;

  @Column(name = "endofvaliditydate")
  private String endofvaliditydate;

  @Column(name = "uploadproof")
  private String uploadproof;

  @Column(name = "addressproof")
  private String addressproof;

  @Column(name = "tax_identification_number")
  private String taxIdentificationNumber;

  @Column(name = "tax_attestation_proof")
  private String taxAttestationProof;

  @Transient private String uploadProofContentType;

  @Transient private String addressProofContentType;

  @Transient private String taxAttestationProofContentType;

  @Transient private String docType;

  public String getUploadProofContentType() {
    return uploadProofContentType;
  }

  public void setUploadProofContentType(String uploadProofContentType) {
    this.uploadProofContentType = uploadProofContentType;
  }

  public String getAddressProofContentType() {
    return addressProofContentType;
  }

  public void setAddressProofContentType(String addressProofContentType) {
    this.addressProofContentType = addressProofContentType;
  }

  public String getDocType() {
    return docType;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }

  public String getUploadproof() {
    return uploadproof;
  }

  public void setUploadproof(String uploadproof) {
    this.uploadproof = uploadproof;
  }

  public String getAddressproof() {
    return addressproof;
  }

  public void setAddressproof(String addressproof) {
    this.addressproof = addressproof;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public String getDateofdelivery() {
    return dateofdelivery;
  }

  public void setDateofdelivery(String dateofdelivery) {
    this.dateofdelivery = dateofdelivery;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getStateofdelivery() {
    return stateofdelivery;
  }

  public void setStateofdelivery(String stateofdelivery) {
    this.stateofdelivery = stateofdelivery;
  }

  public String getEndofvaliditydate() {
    return endofvaliditydate;
  }

  public void setEndofvaliditydate(String endofvaliditydate) {
    this.endofvaliditydate = endofvaliditydate;
  }

  public String getTaxIdentificationNumber() {
    return taxIdentificationNumber;
  }

  public void setTaxIdentificationNumber(String taxIdentificationNumber) {
    this.taxIdentificationNumber = taxIdentificationNumber;
  }

  public String getTaxAttestationProof() {
    return taxAttestationProof;
  }

  public void setTaxAttestationProof(String taxAttestationProof) {
    this.taxAttestationProof = taxAttestationProof;
  }

  public String getTaxAttestationProofContentType() {
    return taxAttestationProofContentType;
  }

  public void setTaxAttestationProofContentType(String taxAttestationProofContentType) {
    this.taxAttestationProofContentType = taxAttestationProofContentType;
  }
}
