package com.biapay.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "referral_graph_check_task")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReferralGraphCheckTask extends Auditable<String> {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "referral_graph_check_task_seq_generator")
  @SequenceGenerator(
      name = "referral_graph_check_task_seq_generator",
      allocationSize = 1,
      sequenceName = "referral_graph_check_task_seq")
  @Column(name = "id")
  private Long id;

  @Column(name = "client_business_id", nullable = false)
  private String clientBusinessID;

  @Column(name = "friend_business_id", nullable = true)
  private String friendBusinessID;

  @Cascade({CascadeType.SAVE_UPDATE})
  @Column(name = "user_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private UserType userType;
}
