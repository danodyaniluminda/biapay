package com.biapay.core.repository;

import com.biapay.core.model.KycRejectReason;
import com.biapay.core.model.Language;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KycRejectReasonRepository extends JpaRepository<KycRejectReason, Long> {

  List<KycRejectReason> findAllByLanguage(Language language);

}
