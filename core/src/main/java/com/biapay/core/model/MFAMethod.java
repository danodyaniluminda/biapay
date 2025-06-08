package com.biapay.core.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mfa_methods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MFAMethod {
  @Id
  @Enumerated(EnumType.STRING)
  private MFAMethodType mfaMethodId;

  private String name;
  private String nameLocaleKey;
  private String description;
  private String descriptionLocaleKey;
  private int sortOrder;
}
