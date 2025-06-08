package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "mfa_code")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MFACode extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Transient private String mfaCode;

  @Column(name = "mfa_hash")
  private String mfaHash;

  @Column(name = "mfa_code_hash")
  private String mfaCodeHash;

  @Column(name = "is_used")
  private boolean used;

  @Column(name = "user_type")
  @Enumerated(EnumType.STRING)
  private UserType userType;

  @Column(name = "sms_template")
  private String smsTemplate;

  @Column(name = "locale")
  private String locale;

  @Column(name = "expiry_date")
  private LocalDateTime expiryDate;

  @Column(name = "is_expired")
  private boolean expired;

  @Column(name = "email")
  private String email;

  private String userId;

  @Column(name = "via_email")
  private boolean viaEmail;

  @Column(name = "via_authenticator")
  private boolean viaAuthenticator;

  @Column(name = "via_sms")
  private boolean viaSms;

  @Column(name = "via_push_notification")
  private boolean viaPushNotification;

  @Column(name = "email_template")
  private String emailTemplate;

  @Column(name = "generated_at")
  private LocalDateTime generatedAt;
}
