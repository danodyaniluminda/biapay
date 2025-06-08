package com.biapay.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTransactionLimitResponse {

    private long userId;
    private String name;
    private String phone;
    private String email;
    private UserType userType;
    private List<Limitations> limitations = new ArrayList<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Limitations{
        private BigDecimal dailySendingLimitConsumed = BigDecimal.ZERO;
        private BigDecimal weeklySendingLimitConsumed = BigDecimal.ZERO;
        private BigDecimal monthlySendingLimitConsumed = BigDecimal.ZERO;
        private String dailySendingLimitConsumedOf;
        private String weeklySendingLimitConsumedOf;
        private String monthlySendingLimitConsumedOf;
        private String dailySendingLimitConsumedPercentage;
        private String weeklySendingLimitConsumedPercentage;
        private String monthlySendingLimitConsumedPercentage;
        private BigDecimal dailyReceivingLimitConsumed = BigDecimal.ZERO;
        private BigDecimal weeklyReceivingLimitConsumed = BigDecimal.ZERO;
        private BigDecimal monthlyReceivingLimitConsumed = BigDecimal.ZERO;
        private String dailyReceivingLimitConsumedOf;
        private String weeklyReceivingLimitConsumedOf;
        private String monthlyReceivingLimitConsumedOf;
        private String dailyReceivingLimitConsumedPercentage;
        private String weeklyReceivingLimitConsumedPercentage;
        private String monthlyReceivingLimitConsumedPercentage;
        private TransactionLimitManagement transactionLimitConfiguration;
        private UserTransactionLimitManagement userTransactionLimitConfiguration;
    }
}
