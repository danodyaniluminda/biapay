package com.biapay.core.repository;

import com.biapay.core.model.PaymentCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PaymentCategoryRepository extends CrudRepository<PaymentCategory, Long> {
  Optional<PaymentCategory> findByName(String name);

  @Query(
      value =
          "select distinct category from PaymentCategory category"
              + " left join fetch category.paymentMethods")
  public List<PaymentCategory> findAllWithPaymentMethods();
}
