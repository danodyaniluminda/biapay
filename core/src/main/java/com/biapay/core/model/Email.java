package com.biapay.core.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name = "email")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Email extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String subject;

  private String fromAddress;

  private String toAddress;

  private String ccAddress;

  private String bccAddress;

  private String content;

  @Enumerated(EnumType.STRING)
  private EmailStatus status;

  private boolean isHtml;
}
