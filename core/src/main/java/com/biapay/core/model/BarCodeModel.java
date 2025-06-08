package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "barcode")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class BarCodeModel extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "barcode_seq")
  @SequenceGenerator(name = "barcode_seq", allocationSize = 1, sequenceName = "barcode_seq")
  private Long id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "barcode")
  private String barCode;
}
