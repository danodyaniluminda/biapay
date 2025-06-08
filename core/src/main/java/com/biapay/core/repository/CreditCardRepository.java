package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.profile.CardType;
import com.biapay.core.model.profile.CreditCard;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
  Optional<List<CreditCard>> findByCardTypeAndNameAndNumber(
      CardType cardType, String name, String number);

  Optional<List<CreditCard>> findByMerchant(Merchant merchant);
}
