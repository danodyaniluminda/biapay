package com.biapay.core.model.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "branch")
public class Branch {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_seq")
  @SequenceGenerator(name = "branch_seq", allocationSize = 1, sequenceName = "branch_seq")
  private Long branch_id;

  @NotNull @Column private String branchName;

  @Column private String branchCode;

  @ManyToOne(fetch = FetchType.LAZY)
  private ProfileBank profileBank;
}
