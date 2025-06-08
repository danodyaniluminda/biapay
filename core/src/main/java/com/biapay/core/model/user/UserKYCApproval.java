package com.biapay.core.model.user;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.model.AdminUser;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_kyc_approval")
public class UserKYCApproval {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_kyc_approval_seq")
  @SequenceGenerator(
      name = "user_kyc_approval_seq",
      allocationSize = 1,
      sequenceName = "user_kyc_approval_seq")
  private Long id;

  @OneToOne AdminUser makerAdmin;

  @Column Date date;

  @OneToOne
  @JoinColumn(name = "user_kyc_id")
  UserKYC userKYC;

  @Column String comment;

  @Enumerated(EnumType.STRING)
  KycApprovalStatus initialStatus;

  @Enumerated(EnumType.STRING)
  KycApprovalStatus finalStatus;
}
