package com.biapay.core.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Embeddable
public class MerchantSettlementAccountId implements Serializable {
  @ManyToOne
  @NotNull
  @JoinColumn(name = "merchant_pos_id")
  private MerchantPOS merchantPOS;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "payment_method_id")
  private PaymentMethod paymentMethod;
}
