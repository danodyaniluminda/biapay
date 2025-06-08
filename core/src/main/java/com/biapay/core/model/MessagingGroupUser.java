package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "messaging_groups_users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
public class MessagingGroupUser {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messaging_groups_users_id_seq")
  @SequenceGenerator(
      name = "messaging_groups_users_id_seq",
      allocationSize = 1,
      sequenceName = "messaging_groups_users_id_seq")
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "group_id")
  private MessagingUserGroup group;
}
