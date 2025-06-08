package com.biapay.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "merchant_account")
public class UserAccount extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_account_seq")
  @SequenceGenerator(
      name = "merchant_account_seq",
      allocationSize = 1,
      sequenceName = "merchant_account_seq")
  private Long id;
  /*
   * @Column(name = "customer") private CustomerData user;
   */
  @Column(name = "acc_no")
  private Long accountNum;

  @Column(name = "balance")
  private Double balance;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAccountNum() {
    return accountNum;
  }

  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }
}
