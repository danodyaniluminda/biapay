package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "country",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "iso3",
          columnNames = {"iso3"}),
      @UniqueConstraint(
          name = "phonecode",
          columnNames = {"phonecode"}),
      @UniqueConstraint(
          name = "numcode",
          columnNames = {"numcode"})
    })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
public class Country extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
  @SequenceGenerator(name = "country_seq", allocationSize = 1, sequenceName = "country_seq")
  private Long id;

  @Column(name = "shortName")
  private String shortName;

  @Column(name = "longName")
  private String longName;

  @Column(name = "iso3", unique = true)
  private String iso3;

  @Column(name = "numcode")
  private int numcode;

  @Column(name = "phonecode", unique = true)
  private int phonecode;

  @Column(name = "gimacpay_enabled", unique = true)
  private boolean gimacPayEnabled;
}
