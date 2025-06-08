package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "language")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_seq")
  @SequenceGenerator(name = "language_seq", allocationSize = 1, sequenceName = "language_seq")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "shortname")
  private String shortname;

  @Column(name = "flag")
  private String flag;

  @Column(name = "status")
  private boolean status;

  @Transient private String docType;

  @Transient private String tempImage;

  public String getTempImage() {
    return tempImage;
  }

  public void setTempImage(String tempImage) {
    this.tempImage = tempImage;
  }

  public Language() {}

  public Language(String name, String shortname, String flag, boolean status) {
    super();
    this.name = name;
    this.shortname = shortname;
    this.flag = flag;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShortname() {
    return shortname;
  }

  public void setShortname(String shortname) {
    this.shortname = shortname;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getDocType() {
    return docType;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }
}
