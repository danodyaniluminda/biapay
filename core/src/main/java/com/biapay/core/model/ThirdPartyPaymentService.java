package com.biapay.core.model;

import com.biapay.core.model.enums.FeePayer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "payment_service")
@Getter
@Setter
@ToString
public class ThirdPartyPaymentService {

  @Id
  @NotNull
  private Long id;

  @Column(name = "name")
  @NotNull
  private String name;

  @Column(name = "description")
  @NotNull
  private String description;

  @Column(name = "status")
  @NotNull
  private Boolean status;

  @Column(name = "fee_payer")
  @Enumerated(EnumType.STRING)
  private FeePayer feePayer;

  @Override
  public boolean equals(Object obj) {
    return id.equals(((ThirdPartyPaymentService) obj).getId());
  }
}
