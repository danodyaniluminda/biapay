package com.biapay.core.service;

import com.biapay.core.dto.SubscriptionPlanLimitDTO;
import com.biapay.core.exception.NotFoundException;
import com.biapay.core.model.Merchant;
import com.biapay.core.repository.MerchantRepository;
import com.biapay.core.repository.SubscriptionPlanRepository;
import javax.persistence.Tuple;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SubscriptionLimitService {

  private final MerchantRepository merchantRepository;

  @Autowired SubscriptionPlanRepository subscriptionPlanRepository;

  public SubscriptionPlanLimitDTO getSubscribedPlanLimit(Long merchantId) {
    //    first get the merchant by id
    Merchant merchant =
        merchantRepository
            .findById(merchantId)
            .orElseThrow(() -> new NotFoundException("Merchant not found"));

    Tuple resultSet = subscriptionPlanRepository.getSubscriptionLimitDetails(merchantId);

    return SubscriptionPlanLimitDTO.builder()
        .merchant(merchant)
        .maxAllowedSubUsers(getData(resultSet, "max_sub_users"))
        .availedSubUsers(getData(resultSet, "availed_sub_users"))
        .remainingSubUsers(
            getData(resultSet, "max_sub_users") - getData(resultSet, "availed_sub_users"))
        .maxAllowedShops(getData(resultSet, "max_shops"))
        .availedShops(getData(resultSet, "availed_shops"))
        .remainingShops(getData(resultSet, "max_shops") - getData(resultSet, "availed_shops"))
        .maxAllowedPOSPerShop(getData(resultSet, "max_pos_per_shop"))
        .availedPOSPerShop(getData(resultSet, "availed_pos_per_shop"))
        .remainingPOSPerShop(
            getData(resultSet, "max_pos_per_shop") - getData(resultSet, "availed_pos_per_shop"))
        .maxAllowedListedProducts(getData(resultSet, "max_listed_products"))
        .availedListedProducts(getData(resultSet, "availed_listed_products"))
        .remainingListedProducts(
            getData(resultSet, "max_listed_products")
                - getData(resultSet, "availed_listed_products"))
        .maxAllowedPublishedEvents(getData(resultSet, "max_published_events"))
        .availedPublishedEvents(getData(resultSet, "availed_events"))
        .remainingPublishedEvents(
            getData(resultSet, "max_published_events") - getData(resultSet, "availed_events"))
        .build();
  }

  private Integer getData(Tuple resultSet, String column) {
    return Integer.parseInt(resultSet.get(column).toString());
  }
}
