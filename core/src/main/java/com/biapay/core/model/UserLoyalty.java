package com.biapay.core.model;

import com.biapay.core.model.enums.LoyaltyType;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.*;
import lombok.*;

@Table(name = "user_loyalty")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoyalty extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "loyalty_campaign_id")
  private Campaign campaign;

  @Column(name = "benefit_type")
  @Enumerated(EnumType.STRING)
  private LoyaltyType benefitType;

  @Column(name = "amount_type")
  @Enumerated(EnumType.STRING)
  private Loyalty.AmountType amountType;

  @Column(name = "loyalty_points")
  private int loyaltyPoints;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "percentage")
  private BigDecimal percentage;

  @Column(name = "expires_at")
  private Timestamp expiresAt;

  @OneToOne
  @JoinColumn(name = "user_loyalty_activities_id", referencedColumnName = "id")
  private UserLoyaltyActivity userLoyaltyActivity;
}
