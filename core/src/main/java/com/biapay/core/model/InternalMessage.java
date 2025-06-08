package com.biapay.core.model;

import com.biapay.core.model.enums.ImStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "internal_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class InternalMessage extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "internal_message_id_seq")
  @SequenceGenerator(
          name = "internal_message_id_seq",
          allocationSize = 1,
          sequenceName = "internal_message_id_seq")
  private Long id;

  private String subject;

  private String message;

  @Enumerated(EnumType.STRING)
  private ImStatus status;

  private Long groupId;
  private String groupName;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_date", insertable = false, updatable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private Date messageDate;

  private String fileName;
}
