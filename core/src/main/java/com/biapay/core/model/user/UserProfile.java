package com.biapay.core.model.user;

import com.biapay.core.model.CustomerData;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_profile")
public class UserProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_seq")
  @SequenceGenerator(
      name = "user_profile_seq",
      allocationSize = 1,
      sequenceName = "user_profile_seq")
  Long profile_id;

  @Column Boolean twoFA = false;

  @Column String profileImagePath;

  @Column String profileImageContentType;

  @OneToMany(fetch = FetchType.EAGER)
  Set<UserBankAccount> userBankAccounts = new HashSet<>();

  @OneToMany(fetch = FetchType.EAGER)
  Set<UserMobileAccount> userMobileAccounts = new HashSet<>();

  @OneToMany(fetch = FetchType.EAGER)
  Set<UserCreditCard> userCreditCards = new HashSet<>();

  @OneToOne @NotNull CustomerData customerData;

  public void addBankAccount(UserBankAccount account) {
    this.userBankAccounts.add(account);
  }

  public void addMobileAccount(UserMobileAccount account) {
    this.userMobileAccounts.add(account);
  }

  public void addCreditCard(UserCreditCard card) {
    this.userCreditCards.add(card);
  }
}
