package com.biapay.core.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "payout_service")
@Getter
@Setter
@ToString
public class PayoutService {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "url")
  private String url;

  @Column(name = "api_key")
  private String apiKey;

  @Column(name = "api_secret")
  private String apiSecret;

  @Column(name = "other_credential")
  private String otherCredential;

  @Column(name = "status")
  private Boolean status;

  @Override
  public boolean equals(Object obj) {
    PayoutService service = (PayoutService) obj;
    return this.getId().equals(service.getId());
  }
}
