package com.biapay.core.model.user;

import com.biapay.core.model.Country;
import com.biapay.core.model.CustomerData;
import com.biapay.core.model.profile.MobileOperator;
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

@Getter
@Setter
@Entity
@Table(name = "user_mobile_account")
public class UserMobileAccount {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_mobile_account_seq")
  @SequenceGenerator(
      name = "user_mobile_account_seq",
      allocationSize = 1,
      sequenceName = "user_mobile_account_seq")
  private Long account_id;

  @NotNull @ManyToOne private MobileOperator operator;

  @NotNull @ManyToOne private Country country;

  @NotNull @Column private String phoneNumber;

  @NotNull @ManyToOne CustomerData customerData;
}
