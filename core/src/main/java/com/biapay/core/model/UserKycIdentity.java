package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author : A.M
 * @mailto : ahmedmohsenm95@gmail.com
 * @since : 1/26/2024 - 6:20 PM
 **/

@Entity
@Table(name = "user_kyc_identity")
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class UserKycIdentity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "operation_number")
    private String operationNumber;


    @Column(name = "agora_token", columnDefinition = "TEXT")
    private String agoraToken;


    @Column(name = "is_completed")
    private boolean isCompleted;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

}
