package com.biapay.core.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "merchant_shop")
@Getter
@Setter
public class Shop extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_shop_seq")
  @SequenceGenerator(
      name = "merchant_shop_seq",
      allocationSize = 1,
      sequenceName = "merchant_shop_seq")
  private Long shopId;

  @Column @NotNull private String name;

  @ManyToOne @NotNull private Merchant merchant;

  @Column private Boolean status;

  @ManyToMany
  @JoinTable(
      name = "merchant_shop_user",
      joinColumns = @JoinColumn(name = "merchant_shop_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users = new HashSet<>();

  @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<MerchantPOS> merchantPOSList;

  public boolean userInShop(Long userId) {
    return users.stream().filter(u -> u.getUserId().equals(userId)).findFirst().orElse(null) != null;
  }
}
