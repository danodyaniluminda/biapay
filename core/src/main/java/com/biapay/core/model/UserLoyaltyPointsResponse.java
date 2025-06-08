package com.biapay.core.model;

import com.biapay.core.model.enums.LoyaltyType;
import com.biapay.core.model.enums.UserLoyaltyActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoyaltyPointsResponse {

    private int points;
    private LocalDateTime expireAt;
    private String campaignName;
    private String campaignDescription;
    private LoyaltyType loyaltyType;
    private UserLoyaltyActivityType activityType;
    private String recipientFirstName;
    private String recipientEmail;
}
