package com.biapay.core.service;


import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantSubscriptionAttempt;
import com.biapay.core.model.MerchantSubscriptionCompleted;
import com.biapay.core.model.SubscriptionPlan;
import com.biapay.core.model.enums.PaymentStatus;
import com.biapay.core.model.enums.PlanPurchaseStatus;
import com.biapay.core.repository.MerchantSubscriptionAttemptRepository;
import com.biapay.core.repository.MerchantSubscriptionCompletedRepository;
import com.biapay.core.repository.SubscriptionPlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class AddInitialPlanForNewlyCreatedMerchant {


    private final MerchantSubscriptionAttemptRepository merchantSubscriptionAttemptRepository;
    private final MerchantSubscriptionCompletedRepository merchantSubscriptionCompletedRepository;
    private final SubscriptionPlanRepository subscriptionPlanRepository;

    public AddInitialPlanForNewlyCreatedMerchant(MerchantSubscriptionAttemptRepository merchantSubscriptionAttemptRepository, MerchantSubscriptionCompletedRepository merchantSubscriptionCompletedRepository, SubscriptionPlanRepository subscriptionPlanRepository) {
        this.merchantSubscriptionAttemptRepository = merchantSubscriptionAttemptRepository;
        this.merchantSubscriptionCompletedRepository = merchantSubscriptionCompletedRepository;


        this.subscriptionPlanRepository = subscriptionPlanRepository;
    }

    public MerchantSubscriptionCompleted addInitialPlan(Merchant merchant){
        Optional<SubscriptionPlan> subscriptionPlanOptional =subscriptionPlanRepository.findFirstByFlagIsTrueAndDefaultPlanIsTrue();
        if(subscriptionPlanOptional.isPresent()){
            SubscriptionPlan subscriptionPlan = subscriptionPlanOptional.get();
            // we have plan
            boolean exist = merchantSubscriptionAttemptRepository.existsBySubscriptionPlanIdAndMerchant(subscriptionPlan.getId(),merchant);
            if(!exist){
                // we need to add
                MerchantSubscriptionAttempt msa = new MerchantSubscriptionAttempt();
                msa.setMerchant(merchant);
                msa.setSubscriptionPlanId(subscriptionPlan.getId());
                msa.setPaymentStatus(PaymentStatus.COMPLETED);
                msa.setStartDate(LocalDateTime.now());
                msa.setEndDate(LocalDateTime.now().plusDays(365));
                msa.setPlanPurchaseStatus(PlanPurchaseStatus.NEW);
                msa.setDisplayName(subscriptionPlan.getSubscriptionName());
                msa.setCompletedAt(LocalDateTime.now());
                msa.setSubscriptionDays(365L);
                msa.setTransfer(true);
                MerchantSubscriptionAttempt savedMsa =  merchantSubscriptionAttemptRepository.save(msa);

                if(savedMsa!=null && savedMsa.getId()!=null){
                  Optional<MerchantSubscriptionCompleted> optional = merchantSubscriptionCompletedRepository.findByMsaId(savedMsa.getId());
                  if(optional.isEmpty()){
                      MerchantSubscriptionCompleted msc = new MerchantSubscriptionCompleted();
                      msc.setMerchant(savedMsa.getMerchant());
                      msc.setSubscriptionPlanId(savedMsa.getSubscriptionPlanId());
                      msc.setPaymentStatus(PaymentStatus.COMPLETED);
                      msc.setStartDate(savedMsa.getStartDate());
                      msc.setEndDate(savedMsa.getEndDate());
                      msc.setPlanPurchaseStatus(PlanPurchaseStatus.NEW);
                      msc.setDisplayName(savedMsa.getDisplayName());
                      msc.setCompletedAt(savedMsa.getCompletedAt());
                      msc.setSubscriptionDays(savedMsa.getSubscriptionDays());
                      msc.setMsaId(savedMsa.getId());
                      msc.setMaxNumberOfPos(Long.valueOf(subscriptionPlan.getMaxPOSPerShop()));
                      if(msc.getCurrentNumberOfPos()==null){
                          msc.setCurrentNumberOfPos(0L);
                      }
                      msc.setActive(true);
                      msc.setTestPlan(true);
                      return merchantSubscriptionCompletedRepository.save(msc);
                  }
                }else{
                    return null;
                }


            }else{
                return null;
            }


        }else{
            return null;
        }
        return null;

    }
}
