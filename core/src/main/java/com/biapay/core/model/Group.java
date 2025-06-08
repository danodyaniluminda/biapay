package com.biapay.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "`group`")
@Getter
@Setter
public class Group extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
  @SequenceGenerator(name = "group_seq", allocationSize = 1, sequenceName = "group_seq")
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "merchant_id")
  private Merchant merchant;

  @ManyToOne
  @JoinColumn(name = "merchant_pos_id")
  private MerchantPOS merchantPOS;

  @ManyToOne
  @JoinColumn(name = "merchant_shop_id")
  private Shop merchantShop;
}
