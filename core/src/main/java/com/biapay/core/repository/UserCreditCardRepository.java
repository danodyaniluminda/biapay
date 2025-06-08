package com.biapay.core.repository;

import com.biapay.core.model.CustomerData;
import com.biapay.core.model.profile.CardType;
import com.biapay.core.model.user.UserCreditCard;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCreditCardRepository extends JpaRepository<UserCreditCard, Long> {
  Optional<List<UserCreditCard>> findByCardTypeAndNameAndNumber(
      CardType cardType, String name, String number);

  Optional<List<UserCreditCard>> findByCustomerData(CustomerData customerData);
}
