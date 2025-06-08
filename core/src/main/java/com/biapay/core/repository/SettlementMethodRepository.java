package com.biapay.core.repository;

import com.biapay.core.model.PaymentCategory;
import com.biapay.core.model.SettlementMethod;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementMethodRepository extends JpaRepository<SettlementMethod, Long> {

  SettlementMethod findByName(String name);

  Optional<List<SettlementMethod>> findByPaymentCategory(PaymentCategory paymentCategory);

  @Query(value = "from SettlementMethod p" + " left join fetch p.paymentCategory")
  List<SettlementMethod> findAllSettlementMethods();

  @Query(value = "from SettlementMethod p" + " where p.paymentCategory.id = :id")
  List<SettlementMethod> findAllSettlementMethodsByPaymentCategoryId(Long id);

  @Query(
      value =
          "select paymentMethod from SettlementMethod paymentMethod"
              + " left join fetch paymentMethod.paymentCategory"
              + " where paymentMethod.id = :id")
  SettlementMethod findByIdWithCategory(Long id);
}
