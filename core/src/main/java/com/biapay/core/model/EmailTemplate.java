package com.biapay.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "email_template",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "templateNameAndLanguage",
          columnNames = {"templateName", "language_id"})
    })
@Getter
@Setter
public class EmailTemplate extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_template_seq")
  @SequenceGenerator(
      name = "email_template_seq",
      allocationSize = 1,
      sequenceName = "email_template_seq")
  private Long emailTemplateId;

  private String templateName;

  @Column(length = 1000)
  private String subject;

  @Column(columnDefinition = "TEXT")
  private String content;

  @ManyToOne
  @JoinColumn(name = "language_id")
  private Language language;
}
