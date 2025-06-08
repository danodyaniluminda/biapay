package com.biapay.core.model;

import com.biapay.core.model.enums.PaymentStatus;
import com.biapay.core.model.enums.PlanAcquireMethod;
import com.biapay.core.model.enums.PlanPurchaseStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="merchant_subscription_completed",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"display_name", "merchant_id", "subscription_plan_id"}
        )
)
@Entity
public class MerchantSubscriptionCompleted {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(name = "is_active",nullable = false)
    private boolean isActive=true;

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

    @Column(name="msa_id",unique = true,nullable = false)
    private Long msaId;

    @Column(name = "max_number_of_pos")
    private Long maxNumberOfPos;

    @Column(name = "currentNumberOfPos")
    private Long currentNumberOfPos;

    @Column(name = "plan_acquire_method")
    @Enumerated(EnumType.STRING)
    private PlanAcquireMethod planAcquireMethod;

    @Column(name = "is_test_plan",nullable = false)
    private boolean isTestPlan= false;

    @JsonIgnore
    @OneToMany(mappedBy = "merchantSubscriptionCompleted", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MerchantPOS> merchantPOSList = new ArrayList<>();


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
