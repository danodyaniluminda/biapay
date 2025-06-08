package com.biapay.core.model.profile;

import com.biapay.core.model.Country;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "invoice_address")
public class InvoiceAddress {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_address_seq")
  @SequenceGenerator(
      name = "invoice_address_seq",
      allocationSize = 1,
      sequenceName = "invoice_address_seq")
  private Long address_id;

  @ManyToOne private Country country;

  @Column private String city;

  @Column private String street;
}
