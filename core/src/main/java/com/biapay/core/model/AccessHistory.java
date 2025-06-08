package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
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
@Table(name = "access_history")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class AccessHistory extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "access_history_seq")
  @SequenceGenerator(
      name = "access_history_seq",
      allocationSize = 1,
      sequenceName = "access_history_seq")
  private Long id;

  @Column(name = "ipaddress")
  private String ipAddress;

  @Column(name = "browser")
  private String browser;

  @Column(name = "date")
  private Date date;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
