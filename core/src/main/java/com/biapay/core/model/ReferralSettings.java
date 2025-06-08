package com.biapay.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "referral_settings")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReferralSettings {

  @Id
  @Column(name = "key")
  private String key;

  @Column(name = "value")
  private String value;
}
