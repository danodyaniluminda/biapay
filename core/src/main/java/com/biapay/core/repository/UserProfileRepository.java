package com.biapay.core.repository;

import com.biapay.core.model.CustomerData;
import com.biapay.core.model.user.UserProfile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
  Optional<UserProfile> findByCustomerData(CustomerData customerData);
}
