package com.biapay.core.repository;

import com.biapay.core.model.ThirdPartyPaymentService;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentServiceRepository extends JpaRepository<ThirdPartyPaymentService, Long> {
  @Query("update ThirdPartyPaymentService s SET s.name = :name, s.description = :description, s.status = :status where s.id = :id")
  ThirdPartyPaymentService updatePaymentService(@Param(value = "id") Long id, @Param(value = "name") String name,
      @Param(value = "description") String description, @Param(value = "status") Boolean status);
}
