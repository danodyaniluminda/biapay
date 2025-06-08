package com.biapay.core.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "configuration")
@Getter
@Setter
public class Configuration extends Auditable<String> {
  @Id @EmbeddedId private ConfigurationId configurationId;

  private String description;

  private String value;
}
