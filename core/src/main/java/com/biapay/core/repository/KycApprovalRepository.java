package com.biapay.core.repository;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.model.KYC_Form;
import com.biapay.core.model.KycApproval;
import com.biapay.core.model.Merchant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KycApprovalRepository extends JpaRepository<KycApproval, Long> {
  Optional<KycApproval> findFirstByKycFormOrderByDateDesc(KYC_Form kyc_form);

  Optional<List<KycApproval>> findByKycFormOrderByDateDesc(KYC_Form kyc_form);

  @Query(
      value =
          "select * from kyc_approval kya where kya.kyc_id = (select id from kyc where merchant = :merchant and kyc.kyc_approval_status='APPROVED' order by kya.last_modified_at limit 1 ) and kya.final_status = 'APPROVED' order by last_modified_at limit 1",
      nativeQuery = true)
  Optional<KycApproval> findFirstByMerchant(Merchant merchant);

  @Query(
      value =
          "select * from kyc_approval kya where kya.kyc_id = (select id from kyc where merchant = :merchant and kyc.kyc_approval_status= cast(:status AS varchar)  order by kya.last_modified_at limit 1 ) and kya.final_status = cast(:status AS varchar) order by last_modified_at limit 1",
      nativeQuery = true)
  Optional<KycApproval> findFirstByMerchantByKycStatus(Merchant merchant, KycApprovalStatus status);

  @Query(
      value =
          "select * from kyc_approval kya where kya.kyc_id in (select id from kyc where merchant = :merchant order by kya.last_modified_at)",
      nativeQuery = true)
  List<KycApproval> findAllByMerchant(Merchant merchant);

  @Query(
      value =
          "SELECT kya.* FROM kyc_approval kya WHERE kya.kyc_id=:kyc_form AND kya.final_status = :status ORDER BY kya.last_modified_at desc LIMIT 1",
      nativeQuery = true)
  Optional<KycApproval> findFirstByMerchantByKycFormAndKycStatus(KYC_Form kyc_form, String status);

//  @Query(value = "FROM KycApproval kya WHERE kya.kycForm=:kyc_form AND kya.finalStatus = :status and kya.date >= :approvalDateFrom ORDER BY kya.lastModifiedDate desc LIMIT 1")
//  Optional<KycApproval> findAllByMerchantByKycStatusAndApprovalFromDate(String status, Date approvalDateFrom);
//
//  @Query(value = "FROM KycApproval kya WHERE kya.kycForm=:kyc_form AND kya.finalStatus = :status and kya.date <= :approvalDateFrom ORDER BY kya.lastModifiedDate desc LIMIT 1")
//  Optional<KycApproval> findAllByMerchantByKycStatusAndApprovalToDate(String status, Date approvalDateTo);
//
//  @Query(value = "FROM KycApproval kya WHERE kya.kycForm=:kyc_form AND kya.finalStatus = :status and kya.date between :approvalDateFrom and :approvalDateTo ORDER BY kya.lastModifiedDate desc LIMIT 1")
//  Optional<KycApproval> findAllByMerchantByKycStatusAndApprovalBetweenDate(String status, Date approvalDateFrom, Date approvalDateTo);
}
