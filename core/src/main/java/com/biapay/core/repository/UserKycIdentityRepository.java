package com.biapay.core.repository;

import com.biapay.core.model.User;
import com.biapay.core.model.UserKycIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author : A.M
 * @mailto : ahmedmohsenm95@gmail.com
 * @since : 1/26/2024 - 6:56 PM
 **/
public interface UserKycIdentityRepository extends JpaRepository<UserKycIdentity, Long> {

    Optional<UserKycIdentity> findByOperationNumber(String operationNumber);
    boolean existsByOperationNumber(String operationNumber);
    Optional<UserKycIdentity> findByUser(User user);
}
