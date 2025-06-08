package com.biapay.core.model;

import com.biapay.core.constant.enums.MerchantStatus;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "merchant_status_suspension")
public class MerchantStatusSuspension extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_status_suspension_seq")
  @SequenceGenerator(
      name = "merchant_status_suspension_seq",
      allocationSize = 1,
      sequenceName = "merchant_status_suspension_seq")
  Long id;

  @OneToOne @NotNull Merchant merchant;

  @OneToOne @NotNull User admin;

  @Column @NotNull Date changeDate;

  @Column String comment;

  @Column(name = "suspended")
  private boolean suspended;

  @Enumerated(EnumType.STRING)
  MerchantStatus status;

  @Enumerated(EnumType.STRING)
  MerchantStatus initialStatus;
}
