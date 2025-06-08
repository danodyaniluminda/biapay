package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "business_representative")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRepresentative extends Auditable<String> {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  @NotNull
  private String name;
  @Column(name = "surname")
  private String surname;
  @Column(name = "date_of_birth")
  @NotNull
  private String dateOfBirth;
  @Column(name = "id_card")
  @NotNull
  private String idCard;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phone;

  @Column(name = "delivery_date")
  private String deliveryDate;

  @Column(name = "id_expiration_date")
  private String idExpirationDate;

  @Column(name = "delivery_place")
  private String deliveryPlace;




}
