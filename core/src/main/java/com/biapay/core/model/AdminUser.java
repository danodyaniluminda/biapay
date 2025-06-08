package com.biapay.core.model;

import com.biapay.core.constant.enums.AdminGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "admin_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdminUser extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_user_seq")
  @SequenceGenerator(name = "admin_user_seq", allocationSize = 1, sequenceName = "admin_user_seq")
  private Long id;

  @Column(name = "CLIENT_SECRET")
  private String clientSecret;

  @Column(name = "email")
  private String email;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "admin_user_group",
      joinColumns = @JoinColumn(name = "admin_user_id"),
      inverseJoinColumns = @JoinColumn(name = "admin_group_id"))
  private Set<AdminGroup> adminGroup = new HashSet<>();
}
