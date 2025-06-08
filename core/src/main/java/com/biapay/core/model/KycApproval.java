package com.biapay.core.model;

import com.biapay.core.constant.enums.KycApprovalStatus;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "kyc_approval")
public class KycApproval extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kyc_approval_seq")
  @SequenceGenerator(
      name = "kyc_approval_seq",
      allocationSize = 1,
      sequenceName = "kyc_approval_seq")
  private Long id;

  @OneToOne AdminUser makerAdmin;

  @Column Date date;

  @OneToOne
  @JoinColumn(name = "kyc_id")
  KYC_Form kycForm;

  @Column String comment;

  @Enumerated(EnumType.STRING)
  KycApprovalStatus initialStatus;

  @Enumerated(EnumType.STRING)
  KycApprovalStatus finalStatus;

  @OneToOne
  @JoinColumn(name = "reason_id")
  KycRejectReason reason;

  @OneToOne
  @JoinColumn(name = "rejected_by")
  AdminUser rejectedBy;
}
