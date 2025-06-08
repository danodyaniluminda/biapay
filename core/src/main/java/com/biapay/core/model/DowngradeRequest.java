package com.biapay.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "downgrade_request")
@Setter
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DowngradeRequest extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "downgrade_request_seq")
  @SequenceGenerator(
      name = "downgrade_request_seq",
      allocationSize = 1,
      sequenceName = "downgrade_request_seq")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "merchant_id")
  private Merchant merchant;

  @ManyToOne
  @JoinColumn(name = "current_plan")
  private SubscriptionPlan currentPlan;

  @ManyToOne
  @JoinColumn(name = "requested_plan")
  private SubscriptionPlan requestedPlan;

  @Column(name = "request_status")
  private Boolean status;
}
