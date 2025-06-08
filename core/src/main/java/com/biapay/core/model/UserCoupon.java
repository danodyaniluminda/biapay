package com.biapay.core.model;

import com.biapay.core.model.enums.CouponStatus;
import com.biapay.core.model.enums.CouponType;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "user_coupon")
@NoArgsConstructor
@AllArgsConstructor
public class UserCoupon extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "coupon_type")
  @Enumerated(EnumType.STRING)
  private CouponType couponType;

  @Column(name = "coupon_status")
  @Enumerated(EnumType.STRING)
  private CouponStatus couponStatus;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "start_date")
  private LocalDateTime startDate;

  @Column(name = "end_date")
  private LocalDateTime endDate;

  @Column(name = "max_usage")
  private Integer maxUsage;

  @Column(name = "current_usage")
  private Integer currentUsage;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
