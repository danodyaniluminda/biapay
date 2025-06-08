package com.biapay.core.dto;

import com.biapay.core.model.Merchant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPlanLimitDTO {
  private Merchant merchant;
  private Integer maxAllowedSubUsers = 0;
  private Integer availedSubUsers = 0;
  private Integer remainingSubUsers = 0;

  private Integer maxAllowedShops = 0;
  private Integer availedShops = 0;
  private Integer remainingShops = 0;

  private Integer maxAllowedPOSPerShop = 0;
  private Integer availedPOSPerShop = 0;
  private Integer remainingPOSPerShop = 0;

  private Integer maxAllowedListedProducts = 0;
  private Integer availedListedProducts = 0;
  private Integer remainingListedProducts = 0;

  private Integer maxAllowedPublishedEvents = 0;
  private Integer availedPublishedEvents = 0;
  private Integer remainingPublishedEvents = 0;

  //  private List<TransactionLimitDTO> transactionLimits;
}
