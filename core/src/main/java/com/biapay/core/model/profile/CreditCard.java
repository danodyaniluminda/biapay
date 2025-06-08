package com.biapay.core.model.profile;

import com.biapay.core.model.Merchant;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "credit_card")
public class CreditCard {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_card_seq")
  @SequenceGenerator(name = "credit_card_seq", allocationSize = 1, sequenceName = "credit_card_seq")
  private Long card_id;

  @NotNull @ManyToOne private CardType cardType;

  @NotNull @Column private String name;

  @NotNull @Column private String number;

  @NotNull @Column private Date expiryDate;

  @OneToOne(cascade = CascadeType.ALL)
  private InvoiceAddress invoiceAddress;

  @NotNull @ManyToOne Merchant merchant;
}
