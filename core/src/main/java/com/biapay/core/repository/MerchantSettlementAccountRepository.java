package com.biapay.core.repository;

import com.biapay.core.model.MerchantSettlementAccount;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantSettlementAccountRepository extends JpaRepository<MerchantSettlementAccount, Long> {

  List<MerchantSettlementAccount> findByMerchantPosId(Long merchantPosId);

  @Query(
      "select merchantSettlementAccount from MerchantSettlementAccount merchantSettlementAccount "
          + " where merchantSettlementAccount.defaultAcc = true and merchantSettlementAccount.merchantPosId = :merchantPosId")
  Optional<List<MerchantSettlementAccount>> findDefaultAccountByMerchantPosId(Long merchantPosId);

  //    @Modifying
  //    @Query("delete from MerchantSettlementAccount merchantSettlementAccount "
  //            + " where merchantSettlementAccount.merchantPosId = :merchantPosId")
  Long deleteByMerchantPosId(Long merchantPosId);

  @Query(
      "select merchantSettlementAccount from MerchantSettlementAccount merchantSettlementAccount "
          + " where merchantSettlementAccount.paymentMethodId = :paymentMethodId and merchantSettlementAccount.merchantPosId = :merchantPosId")
  Optional<List<MerchantSettlementAccount>> findAccountByMerchantPosIdAndPaymentMethodId(
      Long merchantPosId, Long paymentMethodId);
}
