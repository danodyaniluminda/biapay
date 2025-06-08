package com.biapay.core.repository;

import com.biapay.core.model.Currency;
import com.biapay.core.model.PaymentCategory;
import com.biapay.core.model.PaymentMethod;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

  PaymentMethod findByName(String name);

  Optional<List<PaymentMethod>> findByPaymentCategory(PaymentCategory paymentCategory);

  @Query(value = "from PaymentMethod p" + " left join fetch p.paymentCategory")
  List<PaymentMethod> findAllPaymentMethods();

  @Query(value = "from PaymentMethod p" + " where p.paymentCategory.id = :id")
  List<PaymentMethod> findAllPaymentMethodsByPaymentCategoryId(Long id);

  @Query(
      value =
          "select paymentMethod from PaymentMethod paymentMethod"
              + " left join fetch paymentMethod.paymentCategory"
              + " where paymentMethod.id = :id")
  PaymentMethod findByIdWithCategory(Long id);

  Optional<List<PaymentMethod>> findAllByCurrenciesContaining(Currency currency);
}
