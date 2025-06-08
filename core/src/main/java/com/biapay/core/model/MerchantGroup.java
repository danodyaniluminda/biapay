package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "merchant_group")
public class MerchantGroup extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_group_id_seq")
  @SequenceGenerator(name = "merchant_group_id_seq", sequenceName = "merchant_group_id_seq_gen")
  @Column(name = "id")
  private Long id;

  @NotNull String name;

  String description;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "merchant_group_merchant",
      joinColumns = @JoinColumn(name = "merchant_group_id"),
      inverseJoinColumns = @JoinColumn(name = "merchant_id"))
  Set<Merchant> merchants;
}
