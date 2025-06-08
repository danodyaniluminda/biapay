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

@Setter
@Getter
@Entity
@Table(name = "subscription_plan_merchants")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user"})
public class TagSubscriptionPlan extends Auditable<String> {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "subscription_plan_merchant_id_seq")
  @SequenceGenerator(
      name = "subscription_plan_merchant_id_seq",
      allocationSize = 1,
      sequenceName = "subscription_plan_merchant_id_seq")
  @Column(name = "id")
  private Long id;

  @Column(name = "plan_id")
  private Long planId;

  @Column(name = "merchant_id")
  private Long merchantId;
}
