package com.biapay.core.model;


import com.biapay.core.model.enums.PaymentStatus;
import com.biapay.core.model.enums.PlanAcquireMethod;
import com.biapay.core.model.enums.PlanPurchaseStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "merchant_subscription_attempt")
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MerchantSubscriptionAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(name="subscription_plan_id")
    private Long subscriptionPlanId;

    @Column(name="payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name="pay_link_id")
    private Long payLinkId;

    @Column(name="client_transaction_id")
    private UUID clientTransactionId;

    @Column(name = "plan_purchase_status")
    @Enumerated(EnumType.STRING)
    private PlanPurchaseStatus planPurchaseStatus;

    @Column(name="display_name")
    private String displayName;

    @Column(name="completed_at")
    private LocalDateTime completedAt;

    @Column(name="subscription_days")
    private Long subscriptionDays;

    @Column(name="is_transfer")
    private boolean isTransfer=false;

    @Column(name = "plan_acquire_method")
    @Enumerated(EnumType.STRING)
    private PlanAcquireMethod planAcquireMethod;


    @PrePersist
    public void generate(){
        this.createdAt= LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
        if (this.planAcquireMethod == null) {
            this.planAcquireMethod = PlanAcquireMethod.MERCHANT_PURCHASED;
        }
    }

    @PreUpdate
    public void generateUpdatedAt(){
        this.updatedAt=LocalDateTime.now();
    }





}
