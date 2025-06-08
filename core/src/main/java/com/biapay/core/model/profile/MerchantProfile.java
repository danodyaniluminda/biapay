package com.biapay.core.model.profile;

import com.biapay.core.model.Merchant;
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

@Entity
@Getter
@Setter
@Table(name = "merchant_profile")
public class MerchantProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_profile_seq")
  @SequenceGenerator(
      name = "merchant_profile_seq",
      allocationSize = 1,
      sequenceName = "merchant_profile_seq")
  Long profile_id;

  @Column Boolean twoFA = false;

  @Column String profileImagePath;

  @Column String profileImageContentType;

  @OneToMany(fetch = FetchType.EAGER)
  Set<BankAccount> bankAccounts = new HashSet<>();

  @OneToMany(fetch = FetchType.EAGER)
  Set<MobileAccount> mobileAccounts = new HashSet<>();

  @OneToMany(fetch = FetchType.EAGER)
  Set<CreditCard> creditCards = new HashSet<>();

  @OneToOne @NotNull Merchant merchant;

  public void addBankAccount(BankAccount account) {
    this.bankAccounts.add(account);
  }

  public void addMobileAccount(MobileAccount account) {
    this.mobileAccounts.add(account);
  }

  public void addCreditCard(CreditCard card) {
    this.creditCards.add(card);
  }
}
