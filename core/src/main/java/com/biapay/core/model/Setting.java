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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "setting")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class Setting extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setting_seq")
  @SequenceGenerator(name = "setting_seq", allocationSize = 1, sequenceName = "setting_seq")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "google_reCAPTCHA")
  private boolean google_reCAPTCHA;

  @Column(name = "currency")
  private String currency;

  @Column(name = "languages")
  private String languages;

  @Column(name = "logo")
  private String logo;

  @Column(name = "favicon")
  private String favicon;

  @Column(name = "google_analytics_tracking_code")
  private String google_analytics_tracking_code;

  @Transient private String docType;

  @Transient private String tempLogo;

  @Transient private String tempFavicon;
}
