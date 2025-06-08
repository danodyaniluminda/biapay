package com.biapay.core.model.profile;

import com.biapay.core.model.Country;
import com.biapay.core.model.Currency;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "profile_bank")
public class ProfileBank {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_bank_seq")
  @SequenceGenerator(
      name = "profile_bank_seq",
      allocationSize = 1,
      sequenceName = "profile_bank_seq")
  private Long bank_id;

  @Column(unique = true)
  @NotNull
  private String bankFullName;

  @Column private String bankShortName;

  @Column @NotNull private String bankCode;

  @ManyToOne private Country country;

  @ManyToMany(fetch = FetchType.EAGER)
  @NotNull
  private Set<Currency> currencies = new HashSet<>();

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(insertable = false, updatable = false)
  private Set<Branch> branches = new HashSet<>();

  public void addCurrency(Currency currencies) {
    this.currencies.add(currencies);
  }

  public void addBranch(Branch branch) {
    this.branches.add(branch);
  }
}
