package com.biapay.core.model.profile;

import com.biapay.core.model.Country;
import com.biapay.core.model.Merchant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "mobile_account")
public class MobileAccount {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobile_account_seq")
  @SequenceGenerator(
      name = "mobile_account_seq",
      allocationSize = 1,
      sequenceName = "mobile_account_seq")
  private Long account_id;

  @NotNull @ManyToOne private MobileOperator operator;

  @NotNull @ManyToOne private Country country;

  @NotNull @Column private String phoneNumber;

  @NotNull @ManyToOne Merchant merchant;
}
