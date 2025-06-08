package com.biapay.core.service;

import com.biapay.core.exception.InvalidRequestException;
import com.biapay.core.exception.NotFoundException;
import com.biapay.core.model.*;
import com.biapay.core.model.enums.TransactionIdType;
import com.biapay.core.model.enums.UserTransactionLimitStatus;
import com.biapay.core.repository.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserTransactionLimitService {
  private final MerchantRepository merchantRepository;
  private final TransactionLimitManagementRepository transactionLimitManagementRepository;
  private final MerchantSubscriptionRepository merchantSubscriptionRepository;
  private final UserTransactionLimitRepository userTransactionLimitRepository;
  private final UserRepository userRepository;
  private final UserTransactionLimitManagementRepository userTransactionLimitManagementRepository;

  public UserTransactionLimit checkUserTransactionLimit(
      Long merchantId,
      String email,
      Long merchantPostId,
      String currency,
      BigDecimal amount,
      boolean isMerchant, boolean isSending) {
    UserTransactionLimit transactionLimit = null;
    User user;
    if (isMerchant && !isSending) {
      Merchant merchant =
          merchantRepository
              .findById(merchantId)
              .orElseThrow(() -> new NotFoundException("Merchant Not found."));
      user = merchant.getRootUser();
    } else {
      user = userRepository.findByEmailAndUserType(email, UserType.USER);
    }
    if (user == null) {
      return null;
    }
    TransactionLimitManagement limitManagement = null;
    UserTransactionLimitManagement userTransactionLimitManagement
            = userTransactionLimitManagementRepository.findByCurrency_CodeAndUser_userId(currency, user.getUserId()).orElse(null);

    if (userTransactionLimitManagement != null) {
      return calculateUserSpecificTransactionLimit(amount, isSending, user, userTransactionLimitManagement);
    }

    return calculateUserGeneralTransactionLimit(merchantPostId, currency, amount, isMerchant, isSending, transactionLimit, user, limitManagement);
  }



  private UserTransactionLimit calculateUserSpecificTransactionLimit(BigDecimal amount, boolean isSending, User user, UserTransactionLimitManagement userTransactionLimitManagement) {
    UserTransactionLimit transactionLimit;
    if (isSending) {
      if (amount.compareTo(userTransactionLimitManagement.getSendingDaily()) > 0
              || amount.compareTo(userTransactionLimitManagement.getSendingWeekly()) > 0
              || amount.compareTo(userTransactionLimitManagement.getSendingMonthly()) > 0) {
        throw new InvalidRequestException(
                "Request exceeds allowed transaction limit for this user");
      }
    } else {
      if (amount.compareTo(userTransactionLimitManagement.getReceivingDaily()) > 0
              || amount.compareTo(userTransactionLimitManagement.getReceivingWeekly()) > 0
              || amount.compareTo(userTransactionLimitManagement.getReceivingMonthly()) > 0) {
        throw new InvalidRequestException(
                "Request exceeds allowed transaction limit for this user");
      }
    }
    transactionLimit = new UserTransactionLimit();
    transactionLimit.setAmount(amount);
    transactionLimit.setStatus(UserTransactionLimitStatus.INITIATED);
    transactionLimit.setUser(user);
    transactionLimit.setUserTransactionLimitManagement(userTransactionLimitManagement);
    transactionLimit.setTransactionIdType(TransactionIdType.PAY_LINK);
    transactionLimit.setSending(isSending);
    LocalDate now = LocalDate.now();
    List<UserTransactionLimit> dailyLimit =
            userTransactionLimitRepository
                    .findAllByUser_UserIdAndUserTransactionLimitManagement_IdAndCreatedAtBetween(
                            user.getUserId(),
                            userTransactionLimitManagement.getId(),
                            Timestamp.valueOf(LocalDateTime.of(now, LocalTime.MIN)),
                            Timestamp.valueOf(LocalDateTime.of(now, LocalTime.MAX)));
    if (dailyLimit != null) {
      BigDecimal currentDailyAmount = BigDecimal.ZERO;
      for (UserTransactionLimit userTransactionLimit : dailyLimit) {
        currentDailyAmount = currentDailyAmount.add(userTransactionLimit.getAmount());
      }
      currentDailyAmount = currentDailyAmount.add(amount);
      if (isSending) {
        if (currentDailyAmount.compareTo(userTransactionLimitManagement.getSendingDaily()) > 0) {
          throw new InvalidRequestException(
                  "Request exceeds allowed transaction limit for this user");
        }
        transactionLimit.setCurrentSendingDaily(currentDailyAmount);
      } else {
        if (currentDailyAmount.compareTo(userTransactionLimitManagement.getReceivingDaily()) > 0) {
          throw new InvalidRequestException(
                  "Request exceeds allowed transaction limit for this user");
        }
        transactionLimit.setCurrentReceivingDaily(currentDailyAmount);
      }
    } else {
      if (isSending) {
        transactionLimit.setCurrentSendingDaily(amount);
      } else {
        transactionLimit.setCurrentReceivingDaily(amount);
      }
    }

    LocalDate firstDayOfWeek =
            now.with(java.time.temporal.TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
    LocalDate lastDayOfWeek =
            now.with(java.time.temporal.TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SUNDAY));
    List<UserTransactionLimit> weeklyLimit =
            userTransactionLimitRepository
                    .findAllByUser_UserIdAndTransactionLimitManagement_IdAndCreatedAtBetween(
                            user.getUserId(),
                            userTransactionLimitManagement.getId(),
                            Timestamp.valueOf(LocalDateTime.of(firstDayOfWeek, LocalTime.MIN)),
                            Timestamp.valueOf(LocalDateTime.of(lastDayOfWeek, LocalTime.MAX)));
    if (weeklyLimit != null) {
      BigDecimal currentWeeklyAmount = BigDecimal.ZERO;
      for (UserTransactionLimit userTransactionLimit : weeklyLimit) {
        currentWeeklyAmount = currentWeeklyAmount.add(userTransactionLimit.getAmount());
      }
      currentWeeklyAmount = currentWeeklyAmount.add(amount);
      if (isSending) {
        if (currentWeeklyAmount.compareTo(userTransactionLimitManagement.getSendingWeekly()) > 0) {
          throw new InvalidRequestException(
                  "Request exceeds allowed transaction limit for this user");
        }
        transactionLimit.setCurrentSendingWeekly(currentWeeklyAmount);
      } else {
        if (currentWeeklyAmount.compareTo(userTransactionLimitManagement.getReceivingWeekly()) > 0) {
          throw new InvalidRequestException(
                  "Request exceeds allowed transaction limit for this user");
        }
        transactionLimit.setCurrentReceivingWeekly(currentWeeklyAmount);
      }
    } else {if (isSending) {
      transactionLimit.setCurrentSendingWeekly(amount);
    }else {
      transactionLimit.setCurrentReceivingWeekly(amount);}
    }
    LocalDate firstDayOfMonth = now.with(java.time.temporal.TemporalAdjusters.firstDayOfMonth());
    LocalDate lastDayOfMonth = now.with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
    List<UserTransactionLimit> monthlyLimit =
            userTransactionLimitRepository
                    .findAllByUser_UserIdAndTransactionLimitManagement_IdAndCreatedAtBetween(
                            user.getUserId(),
                            userTransactionLimitManagement.getId(),
                            Timestamp.valueOf(LocalDateTime.of(firstDayOfMonth, LocalTime.MIN)),
                            Timestamp.valueOf(LocalDateTime.of(lastDayOfMonth, LocalTime.MAX)));
    if (monthlyLimit != null) {
      BigDecimal currentMonthlyAmount = BigDecimal.ZERO;
      for (UserTransactionLimit userTransactionLimit : monthlyLimit) {
        currentMonthlyAmount = currentMonthlyAmount.add(userTransactionLimit.getAmount());
      }
      currentMonthlyAmount = currentMonthlyAmount.add(amount);
      if (isSending) {
        if (currentMonthlyAmount.compareTo(userTransactionLimitManagement.getSendingMonthly()) > 0) {
          throw new InvalidRequestException(
                  "Request exceeds allowed transaction limit for this user");
        }
        transactionLimit.setCurrentSendingMonthly(currentMonthlyAmount);
      } else {
        if (currentMonthlyAmount.compareTo(userTransactionLimitManagement.getReceivingMonthly()) > 0) {
          throw new InvalidRequestException(
                  "Request exceeds allowed transaction limit for this user");
        }
        transactionLimit.setCurrentReceivingMonthly(currentMonthlyAmount);
      }
    } else {
      if (isSending) {
        transactionLimit.setCurrentSendingMonthly(amount);
      }else {
        transactionLimit.setCurrentReceivingMonthly(amount);}
    }
    transactionLimit.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

    return transactionLimit;
  }

  private UserTransactionLimit calculateUserGeneralTransactionLimit(Long merchantPostId, String currency, BigDecimal amount, boolean isMerchant, boolean isSending, UserTransactionLimit transactionLimit, User user, TransactionLimitManagement limitManagement) {
    if (isMerchant) {

      MerchantSubscription merchantSubscription = merchantSubscriptionRepository
              .findByMerchantPOSId(merchantPostId);

      if (merchantSubscription == null){
        limitManagement =
                transactionLimitManagementRepository.findByCurrency_CodeAndUserStatusAndUserType(
                        currency, user.getUserStatus(), user.getUserType());
      }
      else{
        SubscriptionPlan subscriptionPlan =  merchantSubscription.getSubscriptionPlan();

        if (subscriptionPlan != null){
          long subscriptionPlanId = subscriptionPlan.getId();
          limitManagement =
                  transactionLimitManagementRepository
                          .findByCurrency_CodeAndSubscriptionPlan_IdAndUserStatusAndUserType(
                                  currency, subscriptionPlanId, user.getUserStatus(), user.getUserType());
        }
      }
    }
    if (limitManagement == null) {
      limitManagement =
              transactionLimitManagementRepository.findByCurrency_CodeAndUserStatusAndUserType(
                      currency, user.getUserStatus(), user.getUserType());
    }
    if (limitManagement != null) {
      if (isSending) {
        if (amount.compareTo(limitManagement.getSendingDaily()) > 0
                || amount.compareTo(limitManagement.getSendingWeekly()) > 0
                || amount.compareTo(limitManagement.getSendingMonthly()) > 0) {
          throw new InvalidRequestException(
                  "Request exceeds allowed transaction limit for this user");
        }
      } else {
        if (amount.compareTo(limitManagement.getReceivingDaily()) > 0
                || amount.compareTo(limitManagement.getReceivingWeekly()) > 0
                || amount.compareTo(limitManagement.getReceivingMonthly()) > 0) {
          throw new InvalidRequestException(
                  "Request exceeds allowed transaction limit for this user");
        }
      }
      transactionLimit = new UserTransactionLimit();
      transactionLimit.setAmount(amount);
      transactionLimit.setStatus(UserTransactionLimitStatus.INITIATED);
      transactionLimit.setUser(user);
      transactionLimit.setTransactionLimitManagement(limitManagement);
      transactionLimit.setTransactionIdType(TransactionIdType.PAY_LINK);
      transactionLimit.setSending(isSending);

      LocalDate now = LocalDate.now();
      List<UserTransactionLimit> dailyLimit =
              userTransactionLimitRepository
                      .findAllByUser_UserIdAndTransactionLimitManagement_IdAndCreatedAtBetween(
                              user.getUserId(),
                              limitManagement.getId(),
                              Timestamp.valueOf(LocalDateTime.of(now, LocalTime.MIN)),
                              Timestamp.valueOf(LocalDateTime.of(now, LocalTime.MAX)));
      if (dailyLimit != null) {
        BigDecimal currentDailyAmount = BigDecimal.ZERO;
        for (UserTransactionLimit userTransactionLimit : dailyLimit) {
          currentDailyAmount = currentDailyAmount.add(userTransactionLimit.getAmount());
        }
        currentDailyAmount = currentDailyAmount.add(amount);
        if (isSending) {
          if (currentDailyAmount.compareTo(limitManagement.getSendingDaily()) > 0) {
            throw new InvalidRequestException(
                    "Request exceeds allowed transaction limit for this user");
          }
          transactionLimit.setCurrentSendingDaily(currentDailyAmount);
        } else {
          if (currentDailyAmount.compareTo(limitManagement.getReceivingDaily()) > 0) {
            throw new InvalidRequestException(
                    "Request exceeds allowed transaction limit for this user");
          }
          transactionLimit.setCurrentReceivingDaily(currentDailyAmount);
        }
      } else {
        if (isSending) {
          transactionLimit.setCurrentSendingDaily(amount);
        } else {
          transactionLimit.setCurrentReceivingDaily(amount);
        }
      }
      LocalDate firstDayOfWeek =
              now.with(java.time.temporal.TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
      LocalDate lastDayOfWeek =
              now.with(java.time.temporal.TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SUNDAY));
      List<UserTransactionLimit> weeklyLimit =
              userTransactionLimitRepository
                      .findAllByUser_UserIdAndTransactionLimitManagement_IdAndCreatedAtBetween(
                              user.getUserId(),
                              limitManagement.getId(),
                              Timestamp.valueOf(LocalDateTime.of(firstDayOfWeek, LocalTime.MIN)),
                              Timestamp.valueOf(LocalDateTime.of(lastDayOfWeek, LocalTime.MAX)));
      if (weeklyLimit != null) {
        BigDecimal currentWeeklyAmount = BigDecimal.ZERO;
        for (UserTransactionLimit userTransactionLimit : weeklyLimit) {
          currentWeeklyAmount = currentWeeklyAmount.add(userTransactionLimit.getAmount());
        }
        currentWeeklyAmount = currentWeeklyAmount.add(amount);
        if (isSending) {
          if (currentWeeklyAmount.compareTo(limitManagement.getSendingWeekly()) > 0) {
            throw new InvalidRequestException(
                    "Request exceeds allowed transaction limit for this user");
          }
          transactionLimit.setCurrentSendingWeekly(currentWeeklyAmount);
        } else {
          if (currentWeeklyAmount.compareTo(limitManagement.getReceivingWeekly()) > 0) {
            throw new InvalidRequestException(
                    "Request exceeds allowed transaction limit for this user");
          }
          transactionLimit.setCurrentReceivingWeekly(currentWeeklyAmount);
        }
      } else {if (isSending) {
        transactionLimit.setCurrentSendingWeekly(amount);
      }else {
        transactionLimit.setCurrentReceivingWeekly(amount);}
      }
      LocalDate firstDayOfMonth = now.with(java.time.temporal.TemporalAdjusters.firstDayOfMonth());
      LocalDate lastDayOfMonth = now.with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
      List<UserTransactionLimit> monthlyLimit =
              userTransactionLimitRepository
                      .findAllByUser_UserIdAndTransactionLimitManagement_IdAndCreatedAtBetween(
                              user.getUserId(),
                              limitManagement.getId(),
                              Timestamp.valueOf(LocalDateTime.of(firstDayOfMonth, LocalTime.MIN)),
                              Timestamp.valueOf(LocalDateTime.of(lastDayOfMonth, LocalTime.MAX)));
      if (monthlyLimit != null) {
        BigDecimal currentMonthlyAmount = BigDecimal.ZERO;
        for (UserTransactionLimit userTransactionLimit : monthlyLimit) {
          currentMonthlyAmount = currentMonthlyAmount.add(userTransactionLimit.getAmount());
        }
        currentMonthlyAmount = currentMonthlyAmount.add(amount);
        if (isSending) {
          if (currentMonthlyAmount.compareTo(limitManagement.getSendingMonthly()) > 0) {
            throw new InvalidRequestException(
                    "Request exceeds allowed transaction limit for this user");
          }
          transactionLimit.setCurrentSendingMonthly(currentMonthlyAmount);
        } else {
          if (currentMonthlyAmount.compareTo(limitManagement.getReceivingMonthly()) > 0) {
            throw new InvalidRequestException(
                    "Request exceeds allowed transaction limit for this user");
          }
          transactionLimit.setCurrentReceivingMonthly(currentMonthlyAmount);
        }
      } else {
        if (isSending) {
          transactionLimit.setCurrentSendingMonthly(amount);
        }else {
          transactionLimit.setCurrentReceivingMonthly(amount);}
      }
      transactionLimit.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
    }
    return transactionLimit;
  }
}
