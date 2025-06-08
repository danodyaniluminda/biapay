package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@Entity
@Table(name = "user_device")
public class UserDevice {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull private String userId; // userWalletId
  @NotNull private String phoneNumber;
  @JsonIgnore private String token;
  private String deviceId; // key for decryption/encryption // added after activation

  @Enumerated(EnumType.STRING)
  private Status status;

  private String deviceName;
  private String deviceUserAgent;
  @NotNull private String deviceFingerprint;

  @Column(name = "expiry_date")
  private LocalDateTime expiryDate;

  @JsonIgnore @CreatedDate private LocalDateTime createdAt;
  @JsonIgnore @LastModifiedDate private Instant updateAt = Instant.now();

  public enum Status {
    PENDING,
    ACTIVE,
    FROZEN,
    DEACTIVE
  }
}
