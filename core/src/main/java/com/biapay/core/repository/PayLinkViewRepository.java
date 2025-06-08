package com.biapay.core.repository;

import com.biapay.core.model.PayLinkView;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayLinkViewRepository extends JpaRepository<PayLinkView, Long> {
  List<PayLinkView> findAllByPayLink_Uuid(UUID uuId);
}
