package com.biapay.core.constant.enums;

import com.biapay.core.model.Auditable;
import com.biapay.core.model.Role;
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
@Table(name = "admin_group")
@Getter
@Setter
public class AdminGroup extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_group_seq")
  @SequenceGenerator(name = "admin_group_seq", allocationSize = 1, sequenceName = "admin_group_seq")
  private Long id;

  @Column private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "admin_group_role",
      joinColumns = @JoinColumn(name = "admin_group_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;
}
