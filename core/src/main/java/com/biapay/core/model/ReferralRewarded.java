package com.biapay.core.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "referral_rewarded")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReferralRewarded extends Auditable<String> {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "referral_beneficiary_user_id")
  private User referralBeneficiary;

  @ManyToOne
  @JoinColumn(name = "referral_reward_from_user_id")
  private User referralFrom;

  @Column(name = "referral_beneficiary_code")
  private String referralBeneficiaryCode;

  @Column(name = "referral_reward_from_code")
  private String referralFromCode;

  @Column(name = "referral_reward")
  private int referralReward;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_loyalty_id")
  private UserLoyalty userLoyalty;
}
