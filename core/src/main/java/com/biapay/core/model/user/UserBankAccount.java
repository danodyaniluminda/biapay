package com.biapay.core.model.user;

import com.biapay.core.model.Currency;
import com.biapay.core.model.CustomerData;
import com.biapay.core.model.profile.Branch;
import com.biapay.core.model.profile.ProfileBank;
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
@Table(name = "user_bank_account")
public class UserBankAccount {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_bank_account_seq")
  @SequenceGenerator(
      name = "user_bank_account_seq",
      allocationSize = 1,
      sequenceName = "user_bank_account_seq")
  private Long account_id;

  @ManyToOne @NotNull private ProfileBank profileBank;

  @NotNull @ManyToOne private Branch branch;

  @NotNull @Column private Long number;

  @NotNull @Column private Long code;

  @NotNull @ManyToOne private Currency currencies;

  @NotNull @ManyToOne private CustomerData customerData;
}
