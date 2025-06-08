package com.biapay.core.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "kyc_reject_reason")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KycRejectReason extends Auditable<String> {
  @Column(name = "id", nullable = false)
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kyc_reject_reason_seq")
  @SequenceGenerator(
      name = "kyc_reject_reason_seq",
      allocationSize = 1,
      sequenceName = "kyc_reject_reason_seq")
  private Long id;

  @Column(name = "reason", nullable = false)
  private String reason;

  @Column(name = "status", nullable = false)
  private boolean status;

  @ManyToOne
  @JoinColumn(name = "language_id")
  private Language language;
}
