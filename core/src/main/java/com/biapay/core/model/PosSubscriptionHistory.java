package com.biapay.core.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pos_subscription_history")
public class PosSubscriptionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name="pos_id",nullable = false)
    private Long posId;


    @Column(name = "previous_subscription_plan_id",nullable = false)
    private Long previousSubscriptionPlanId;

    @Column(name = "new_subscription_plan_id",nullable = false)
    private Long newSubscriptionPlanId;

    @Column(name="previous_msc_id",nullable = false)
    private Long previousMscId;

    @Column(name = "new_msc_id",nullable = false)
    private Long newMscId;

    @Column(name="notes")
    private String notes;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @PrePersist
    public void generate(){
        this.createdAt= LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
    }

    @PreUpdate
    public void generateUpdatedAt(){
        this.updatedAt=LocalDateTime.now();
    }

}
