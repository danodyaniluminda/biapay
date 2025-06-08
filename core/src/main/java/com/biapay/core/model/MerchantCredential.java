package com.biapay.core.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "merchant_credential")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MerchantCredential {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_credential_seq")
  @SequenceGenerator(
      name = "merchant_credential_seq",
      allocationSize = 1,
      sequenceName = "merchant_credential_seq")
  private Long id;

  private String clientId;

  private String clientSecret;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "merchant_pos_id")
  private MerchantPOS merchantPOS;

  private Boolean downloaded = false;

  @Column(name = "valid_till")
  private LocalDateTime validTill;
}
