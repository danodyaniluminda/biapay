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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "security_answer")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityAnswer extends Auditable<String> {
  @Column(name = "id", nullable = false)
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "security_answer_seq")
  @SequenceGenerator(
      name = "security_answer_seq",
      allocationSize = 1,
      sequenceName = "security_answer_seq")
  private Long id;

  @Column(name = "answer")
  private String answer;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "security_question_id")
  private SecurityQuestion question;
}
