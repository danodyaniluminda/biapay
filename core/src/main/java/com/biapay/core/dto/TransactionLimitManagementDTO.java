package com.biapay.core.dto;

import com.biapay.core.model.UserStatus;
import com.biapay.core.model.UserType;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionLimitManagementDTO {

  private BigDecimal sendingDaily;

  private BigDecimal sendingWeekly;

  private BigDecimal sendingMonthly;

  private BigDecimal receivingDaily;

  private BigDecimal receivingWeekly;

  private BigDecimal receivingMonthly;

  @NotNull private UserType userType;
  @NotNull private UserStatus userStatus;
  @NotNull private Long currencyId;

  private Long subscriptionPlanId;
}
