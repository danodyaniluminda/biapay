package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Builder
@Table(name = "ticket")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ticket_no")
  private String ticketNo;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @Column(name = "priority")
  @Enumerated(EnumType.STRING)
  private TicketPriority priority;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private TicketStatus status;

  @Column(name = "created_date")
  private LocalDateTime createdDateTime;

  @Column(name = "updated_date")
  private LocalDateTime updatedDateTime;

  @Column(name = "closed_date")
  private LocalDateTime closedDateTime;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "created_user_id", nullable = false)
  private User createdUser;

  @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<TicketReply> replies;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "ticket_uploads",
      joinColumns = @JoinColumn(name = "ticket_id"),
      inverseJoinColumns = @JoinColumn(name = "upload_id"))
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Upload> attachments;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "ticket_assignees",
      joinColumns = @JoinColumn(name = "ticket_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  @Fetch(value = FetchMode.SUBSELECT)
  private List<User> assignees;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "ticket_participant",
      joinColumns = @JoinColumn(name = "ticket_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  @Fetch(value = FetchMode.SUBSELECT)
  private List<User> participants;
}
