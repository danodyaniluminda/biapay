package com.biapay.core.repository;

import com.biapay.core.constant.enums.KycApprovalStatus;
import com.biapay.core.model.KYC_Form;
import com.biapay.core.model.Merchant;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KYCFormRepository extends JpaRepository<KYC_Form, Long> {

  KYC_Form findByMerchant(Merchant optmerchantForm);

  List<KYC_Form> findByKycApprovalStatus(KycApprovalStatus status);

  @Query(value = "select * from kyc ky where ky.kyc_approval_status = :kycApprovalStatus and CAST(ky.created_at AS DATE) = :creationDate order by last_modified_at", nativeQuery = true)
  List<KYC_Form> findByCreatedDateAndKycApprovalStatus(Date creationDate, String kycApprovalStatus);

  @Query(value = "select * from kyc kyc where kyc.id = (select id from kyc_approval kya where CAST (kya.date AS DATE) = CAST(:approvalDate AS DATE) and kya.final_status = :kycApprovalStatus) and kyc.kyc_approval_status = :kycApprovalStatus order by last_modified_at", nativeQuery = true)
  List<KYC_Form> findByApprovalDateAndKycApprovalStatus(Date approvalDate, String kycApprovalStatus);

  @Query(value = "select * from kyc kyc where kyc.id = (select id from kyc_approval kya where kya.date = :approvalDate and kya.final_status = cast(:kycApprovalStatus as varchar)) and kyc.kyc_approval_status = :kycApprovalStatus and CAST(kyc.created_at AS DATE) = CAST(:creationDate AS DATE) order by last_modified_at", nativeQuery = true)
  List<KYC_Form> findByApprovalDateAndCreatedDateAndKycApprovalStatus(Date approvalDate, Date creationDate, String kycApprovalStatus);
}
