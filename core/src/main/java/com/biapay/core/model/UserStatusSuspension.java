package com.biapay.core.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_status_suspension")
public class UserStatusSuspension extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_status_suspension_seq")
  @SequenceGenerator(
      name = "user_status_suspension_seq",
      allocationSize = 1,
      sequenceName = "user_status_suspension_seq")
  Long id;

  @OneToOne @NotNull User user;

  @OneToOne @NotNull User admin;

  @Column @NotNull Date changeDate;

  @Column String comment;

  @Column(name = "suspended")
  private boolean suspended;

  @Enumerated(EnumType.STRING)
  UserStatus status;
}
