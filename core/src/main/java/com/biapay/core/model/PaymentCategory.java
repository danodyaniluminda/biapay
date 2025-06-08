package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "payment_category")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Setter
@Getter
@ToString
public class PaymentCategory extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_category_seq")
  @SequenceGenerator(
      name = "payment_category_seq",
      allocationSize = 1,
      sequenceName = "payment_category_seq")
  @Column(name = "payment_category_id")
  Long id;

  @Column(unique = true)
  @NotNull
  String name;

  @OneToMany(mappedBy = "paymentCategory")
  @ToString.Exclude
  // @JoinColumn(name = "payment_category_id")
  Set<PaymentMethod> paymentMethods = new HashSet<>();

  public void addPaymentMethod(PaymentMethod paymentMethod) {
    paymentMethod.setPaymentCategory(null);
    this.paymentMethods.add(paymentMethod);
  }
}
