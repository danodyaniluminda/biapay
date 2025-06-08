package com.biapay.core.model;

import com.sun.istack.NotNull;
import java.time.Instant;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "loyalty_campaign")
public class Campaign extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaign_id_seq")
  @SequenceGenerator(name = "campaign_id_seq", sequenceName = "campaign_id_seq_gen")
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "start_date")
  private Instant startDate;

  @Column(name = "end_date")
  private Instant endDate;

  @Column(name = "all_time")
  private Boolean allTime;

  @JoinColumn(name = "user_group_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private UserLoyaltyGroup userLoyaltyGroup;

  @NotNull
  @Column(name = "active")
  private Boolean active;

  @Column(name = "include_all_users")
  private boolean includeAllUsers;

  @Column(name = "include_all_merchants")
  private boolean includeAllMerchants;

  @ManyToOne
  @JoinColumn(name = "loyalty_transaction_events_id")
  @ToString.Exclude
  @NotNull
  private LoyaltyTransactionEvent loyaltyTransactionEvent;
}
