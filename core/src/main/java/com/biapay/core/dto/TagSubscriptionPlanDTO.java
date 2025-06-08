package com.biapay.core.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TagSubscriptionPlanDTO {
  private String subscriptionName;
  private List<String> merchants;
}
