package com.biapay.core.model.profile;

import com.biapay.core.model.Country;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "mobile_operator")
public class MobileOperator {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobile_operator_seq")
  @SequenceGenerator(
      name = "mobile_operator_seq",
      allocationSize = 1,
      sequenceName = "mobile_operator_seq")
  private Long operator_id;

  @NotNull
  @Column(unique = true)
  private String operatorName;

  @Column private String operatorShortName;

  @ManyToMany(fetch = FetchType.EAGER)
  @NotNull
  private Set<Country> countries = new HashSet<>();

  public void addCountry(Country country) {
    this.countries.add(country);
  }
}
