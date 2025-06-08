package com.biapay.core.model;

import com.biapay.core.model.enums.POSType;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "merchant_pos")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MerchantPOS extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_pos_seq")
  @SequenceGenerator(
      name = "merchant_pos_seq",
      allocationSize = 1,
      sequenceName = "merchant_pos_seq")
  private Long id;

  @NotNull private String name;

  @Column(name = "wallet_address")
  private String walletAddress;

  @ColumnDefault("0")
  @Column(name = "doller_balance")
  private Double dollerBalance;

  @ColumnDefault("0")
  @Column(name = "euro_balance")
  private Double euroBalance;

  @ColumnDefault("0")
  @Column(name = "pound_balance")
  private Double poundBalance;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shop_id")
  private Shop shop;



  @ManyToMany
  @JoinTable(
      name = "merchant_pos_user",
      joinColumns = @JoinColumn(name = "merchant_pos_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users = new HashSet<>();

  @Column private Boolean status;

  @Column private String callbackUrl;

  @Column(name = "is_default")
  private Boolean isDefault;

  @Column(name = "uuid", unique = true)
  private UUID uuid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "qrcode_upload_id")
  private Upload qrCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "barcode_upload_id")
  private Upload barCode;

  @Column(name = "pos_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private POSType type;

  @Column(name = "authorized_domain")
  private String authorizedDomain;

  @Column private Boolean enable;

  // Add Many-to-One relationship with MerchantSubscriptionCompleted
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "msc_id") // Foreign key column
  private MerchantSubscriptionCompleted merchantSubscriptionCompleted;

  @Column(name = "country_id")
  private Long countryId;

}
