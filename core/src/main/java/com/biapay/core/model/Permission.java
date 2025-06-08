package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "permission")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
public class Permission extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_seq")
  @SequenceGenerator(name = "permission_seq", allocationSize = 1, sequenceName = "permission_seq")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "displayname")
  private String displayname;

  @Column(name = "description")
  private String description;

  @Enumerated(EnumType.STRING)
  private PermissionType permissionType;

  @OneToMany(mappedBy = "permission", fetch = FetchType.EAGER)
  private Set<PermissionDisplayName> displayNameSet;
}
