package com.biapay.core.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "security_question")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityQuestion extends Auditable<String> {
  @Column(name = "id", nullable = false)
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "security_question_seq")
  @SequenceGenerator(
      name = "security_question_seq",
      allocationSize = 1,
      sequenceName = "security_question_seq")
  private Long id;

  @Column(name = "question")
  private String question;

  @Column(name = "published")
  private Boolean published;

  @Column(name = "code")
  private String code;

  @ManyToOne
  @JoinColumn(name = "language_id")
  private Language language;
}
