package com.biapay.core.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "whatsapp_log")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WhatsAppLog extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id")
  private long userId;

  @Column(name = "destination")
  private String destination;

  @Column(name = "ref_id")
  private String refId;

  @Column(name = "message")
  private String message;

  @Column(name = "response")
  private String response;

  @Column(name = "status")
  private String status;

  @Column(name = "operator_id")
  private String operatorId;
}
