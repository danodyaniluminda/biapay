package com.biapay.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "sms_log")
public class SMSLog extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_log_seq")
  @SequenceGenerator(name = "sms_log_seq", allocationSize = 1, sequenceName = "sms_log_seq")
  private Long id;

  @Column(name = "ref_id")
  private String refId;

  @Column(name = "status")
  private String status;

  @Column(name = "destination")
  private String destination;

  @Column(name = "mask")
  private String mask;

  @Column(name = "message")
  private String message;

  @Column(name = "operator_id")
  private String operatorId;

  @Column(name = "cost")
  private String cost;

  public SMSLog() {}

  public SMSLog(
      Long id,
      String refId,
      String status,
      String destination,
      String mask,
      String message,
      String operatorId,
      String cost) {
    this.id = id;
    this.refId = refId;
    this.status = status;
    this.destination = destination;
    this.mask = mask;
    this.message = message;
    this.operatorId = operatorId;
    this.cost = cost;
  }
}
