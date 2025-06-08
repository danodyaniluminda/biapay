package com.biapay.core.model;

import com.biapay.core.constant.enums.PushNotificationStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "barcode_push_notification")
public class BarCodePaymentPushNotification extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "barcode_push_notification_seq")
  @SequenceGenerator(
      name = "barcode_push_notification_seq",
      allocationSize = 1,
      sequenceName = "barcode_push_notification_seq")
  private Long id;

  private String title;
  private String message;
  private LocalDateTime date;
  @JsonIgnore @ManyToOne private ClientTransaction clientTransaction;

  @Enumerated(EnumType.STRING)
  private PushNotificationStatus status;
}
