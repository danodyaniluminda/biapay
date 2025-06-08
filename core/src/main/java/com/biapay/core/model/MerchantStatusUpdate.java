package com.biapay.core.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "merchant_status_update")
public class MerchantStatusUpdate extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_status_update_seq")
  @SequenceGenerator(
      name = "merchant_status_update_seq",
      allocationSize = 1,
      sequenceName = "merchant_status_update_seq")
  Long id;

  @Column @NotNull Boolean finalStatus;

  @Column @NotNull Date changeDate;

  @Column String comment;

  @OneToOne @NotNull AdminUser oauth_client_details;

  @OneToOne @NotNull Merchant merchant;
}
