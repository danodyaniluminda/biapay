package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "qrcode")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class QrCodeModel extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qrcode_seq")
  @SequenceGenerator(name = "qrcode_seq", allocationSize = 1, sequenceName = "qrcode_seq")
  private Long id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "qrcode")
  private String qrCode;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getQrCode() {
    return qrCode;
  }

  public String setQrCode(String qrCode) {
    return this.qrCode = qrCode;
  }

  public QrCodeModel get(int i) {
    // TODO Auto-generated method stub
    return null;
  }
}
