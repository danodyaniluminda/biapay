package com.biapay.core.model;

import com.biapay.core.model.enums.UserLoyaltyActivityType;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_loyalty_activities")
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserLoyaltyActivity extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "sender_user_id", nullable = false)
  private Long senderUserId;

  @Column(name = "points")
  private Integer points;

  @Column(name = "recipient_first_name")
  private String recipientFirstName;

  @Column(name = "recipient_last_name")
  private String recipientLastName;

  @Column(name = "recipient_phone_no")
  private String recipientPhoneNo;

  @Column(name = "recipient_email")
  private String recipientEmail;

  @Column(name = "personal_message")
  private String personalMessage;

  @Column(name = "activity_type")
  @Enumerated(EnumType.STRING)
  private UserLoyaltyActivityType activityType;
}
