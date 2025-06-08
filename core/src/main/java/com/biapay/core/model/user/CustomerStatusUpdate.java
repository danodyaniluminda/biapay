package com.biapay.core.model.user;

import com.biapay.core.model.CustomerData;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "customer_status_update")
public class CustomerStatusUpdate {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_status_update_seq")
  @SequenceGenerator(
      name = "customer_status_update_seq",
      allocationSize = 1,
      sequenceName = "customer_status_update_seq")
  Long id;

  @Column @NotNull Boolean finalStatus;

  @Column @NotNull Date changeDate;

  @Column String comment;

  @OneToOne @NotNull CustomerData customerData;
}
