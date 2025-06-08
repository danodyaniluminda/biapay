package com.biapay.core.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "merchant_sub_users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MerchantSubUser extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "merchant_id")
  private Merchant merchant;

  @ManyToOne
  @JoinColumn(name = "merchant_user_id")
  private User merchantUser;

  @ManyToOne
  @JoinColumn(name = "sub_user_id")
  private User subUser;
}
