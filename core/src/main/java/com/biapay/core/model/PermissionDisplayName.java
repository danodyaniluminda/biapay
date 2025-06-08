package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
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
@Table(name = "permission_display_name")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
public class PermissionDisplayName {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_name_seq")
  @SequenceGenerator(
      name = "permission_name_seq",
      allocationSize = 1,
      sequenceName = "permission_name_seq")
  private Long id;

  @Column(name = "display_name")
  private String displayName;

  @ManyToOne
  @JoinColumn(name = "language_id")
  private Language language;

  @ManyToOne
  @JoinColumn(name = "permission_id")
  @JsonIgnore
  private Permission permission;
}
