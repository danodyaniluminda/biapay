package com.biapay.core.model;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "kyc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
public class KYC_Form extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kyc_seq")
  @SequenceGenerator(name = "kyc_seq", allocationSize = 1, sequenceName = "kyc_seq")
  @Column(name = "id")
  private Long id;

  @Column(name = "client")
  private String client;

  @Column(name = "name")
  private String name;

  @Column(name = "dateofbirth")
  private String dateofbirth;

  @Column(name = "emailid")
  private String emailid;

  @Column(name = "mobileno")
  private String mobileno;

  @Column(name = "addressone")
  private String addressone;

  @Column(name = "addresstwo")
  private String addresstwo;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "country")
  private String country;

  @Column(name = "zipcode")
  private int zipcode;

  @Column(name = "longitude")
  private float longitude;

  @Column(name = "latitude")
  private float latitude;

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @OneToOne
  @JoinColumn(name = "merchant")
  private Merchant merchant;

  @OneToOne
  @JoinColumn(name = "identityInformation")
  private IdentityInformation identityInformation;

  @OneToOne
  @JoinColumn(name = "businessdetails")
  private BusinessDetails businessdetails;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "business_representative_id")
  @Getter
  @Setter
  private BusinessRepresentative businessRepresentative;

  @Enumerated(EnumType.STRING)
  private KycApprovalStatus kycApprovalStatus;

  @Column(name = "sector")
  private String sector;

  @Column(name = "preferred_language")
  private String preferredLanguage;

  public Merchant getMerchant() {
    return merchant;
  }

  public void setMerchant(Merchant merchant) {
    this.merchant = merchant;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float f) {
    this.longitude = f;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float f) {
    this.latitude = f;
  }

  public String getClient() {
    return client;
  }

  public void setClient(String client) {
    this.client = client;
  }

  public BusinessDetails getBusinessdetails() {
    return businessdetails;
  }

  public void setBusinessdetails(BusinessDetails businessdetails) {
    this.businessdetails = businessdetails;
  }

  public IdentityInformation getIdentityInformation() {
    return identityInformation;
  }

  public void setIdentityInformation(IdentityInformation identityInformation) {
    this.identityInformation = identityInformation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDateofbirth() {
    return dateofbirth;
  }

  public void setDateofbirth(String dateofbirth) {
    this.dateofbirth = dateofbirth;
  }

  public String getEmailid() {
    return emailid;
  }

  public void setEmailid(String emailid) {
    this.emailid = emailid;
  }

  public String getMobileno() {
    return mobileno;
  }

  public void setMobileno(String mobileno) {
    this.mobileno = mobileno;
  }

  public String getAddressone() {
    return addressone;
  }

  public void setAddressone(String addressone) {
    this.addressone = addressone;
  }

  public String getAddresstwo() {
    return addresstwo;
  }

  public void setAddresstwo(String addresstwo) {
    this.addresstwo = addresstwo;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public int getZipcode() {
    return zipcode;
  }

  public void setZipcode(int zipcode) {
    this.zipcode = zipcode;
  }

  public KycApprovalStatus getKycApprovalStatus() {
    return kycApprovalStatus;
  }

  public void setKycApprovalStatus(KycApprovalStatus kycApprovalStatus) {
    this.kycApprovalStatus = kycApprovalStatus;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getSector() {
    return sector;
  }

  public void setSector(String sector) {
    this.sector = sector;
  }

  public String getPreferredLanguage() {
    return preferredLanguage;
  }

  public void setPreferredLanguage(String preferredLanguage) {
    this.preferredLanguage = preferredLanguage;
  }
}
