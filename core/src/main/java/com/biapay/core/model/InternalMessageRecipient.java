package com.biapay.core.model;

import com.biapay.core.model.enums.ImStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(
    name = "internal_message_recipients",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "internal_message_recipient_index",
          columnNames = {"recipient_id", "message_id"})
    })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user"})
public class InternalMessageRecipient extends Auditable<String> {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "internal_message_recipient_id_seq")
  @SequenceGenerator(
      name = "internal_message_recipient_id_seq",
      allocationSize = 1,
      sequenceName = "internal_message_recipient_id_seq")
  @Column(name = "id")
  private Long id;

  @Column(name = "message_id")
  private Long messageId;

  @Column(name = "recipient_id")
  private Long recipientId;

  @Column(name = "recipient_username")
  private String recipientUserName;

  @Column(name = "recipient_email")
  private String recipientEmail;

  @Column(name = "recipient_phone_no")
  private String recipientPhoneNo;

  @Enumerated(EnumType.STRING)
  private ImStatus status;
}
