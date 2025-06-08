package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "otp_auth_code")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OTPAuthCode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "auth_code")
  private String authCode;

  @Column(name = "user_id")
  private long userId;

  @Column(name = "expiry_date")
  private Timestamp expiryDate;

  @Column(name = "is_expired")
  private boolean expired;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "created_via")
  private String createdVia;

  @Column(name = "created_for")
  private String createdFor;

  @Column(name = "can_resend")
  private boolean canResend;

  @Column(name = "resend_trials")
  private int resendTrials;
}
