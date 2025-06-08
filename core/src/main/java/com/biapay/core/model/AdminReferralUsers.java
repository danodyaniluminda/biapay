package com.biapay.core.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminReferralUsers {

  private Long rewardId;
  private ReferredUsers referredUser;
  private ReferredUsers referredByUser;
  private Date createdDate;
}
