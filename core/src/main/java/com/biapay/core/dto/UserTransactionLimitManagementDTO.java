package com.biapay.core.dto;

import com.biapay.core.model.UserStatus;
import com.biapay.core.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserTransactionLimitManagementDTO {

  private BigDecimal sendingDaily;

  private BigDecimal sendingWeekly;

  private BigDecimal sendingMonthly;

  private BigDecimal receivingDaily;

  private BigDecimal receivingWeekly;

  private BigDecimal receivingMonthly;

  @NotNull
  private Long userId;
  @NotNull
  private Long currencyId;

}
