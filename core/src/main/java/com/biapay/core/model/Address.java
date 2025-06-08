package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
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
@Table(name = "address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class Address extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
  @SequenceGenerator(name = "address_seq", allocationSize = 1, sequenceName = "address_seq")
  private Long id;

  @Column(name = "contact_name")
  private String contactName;

  @Column(name = "phone_number")
  private Long contactNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "address")
  private String address;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "country")
  private String country;

  @Column(name = "zipcode")
  private int zipcode;

  @ManyToOne
  @JoinColumn(name = "merchant_id")
  private Merchant merchant;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
