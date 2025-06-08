package com.biapay.core.repository;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.constant.enums.MerchantStatus;
import com.biapay.core.model.Merchant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

  Optional<Merchant> findById(Long id);

  Merchant findByMerchantName(String merchant);

  @Query(
      "select merchant from Merchant merchant"
          + " left join fetch merchant.rootUser rootUser"
          + " where rootUser.email = :email")
  Merchant findByEmail(String email);

  Merchant findByMerchantSiteId(String siteId);

  Optional<List<Merchant>> findByMerchantStatus(MerchantStatus merchantStatus);

  Optional<List<Merchant>> findByMerchantStatusOrderByCreatedDateDesc(
      MerchantStatus merchantStatus);

  Optional<List<Merchant>> findByKycApprovalStatusOrderByCreatedDateDesc(
      KycApprovalStatus kycApprovalStatus);

  @Query(
      "select count(user) from User user"
          + " where user.mobileNumber = :phone and user.merchant is not null ")
  int countByPhoneAndMerchantId(String phone);

  @Query(
      "select merchant from Merchant merchant"
          + " left join fetch merchant.rootUser rootUser"
          + " where rootUser.emailVerificationToken = :token")
  Optional<Merchant> findByUserEmailVerificationToken(String token);

  Merchant findByPhoneNo(Long phoneNo);

  Merchant findByWallet(String wallet);

  @Query(
      value =
          "select * from merchant where id = (select merchant_id from merchant_shop where shop_id = (select shop_id from merchant_pos where id = (select merchant_pos_id from merchant_credential where client_id = :clientId)))",
      nativeQuery = true)
  //  @Query(
  //      value =
  //          "select merchant from Merchant merchant where merchant = (select merchant from Shop
  // shop where shop = (select shop from MerchantPOS merchantPos where merchantPos = (select
  // merchantPOS from MerchantCredential where clientId = :clientId)))")
  Merchant findByMerchantInfoByClientId(String clientId);

  @Query(value = "SELECT m.* FROM merchant m JOIN merchant_shop ms ON m.id = ms.merchant_id JOIN merchant_pos mp ON ms.shop_id = mp.shop_id WHERE mp.id = :merchantPOSId;", nativeQuery = true)
  Optional<Merchant> findByPOSId(Long merchantPOSId);


  List<Merchant> findAllByPhoneNo(Long phone);
  boolean existsByPhoneNo(Long phone);

}
