package com.biapay.core.repository;

import com.biapay.core.model.Merchant;
import com.biapay.core.model.MerchantStatusSuspension;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantStatusSuspensionRepository
    extends CrudRepository<MerchantStatusSuspension, Long> {
  @Query(
      value =
          "from MerchantStatusSuspension mrst where mrst.merchant= :merchant and mrst.changeDate BETWEEN :startDate AND :endDate")
  Page<MerchantStatusSuspension> findByMerchantAndChangeDate(
      Merchant merchant, Date startDate, Date endDate, Pageable pageable);

  @Query(
      value =
          "from MerchantStatusSuspension mrst where mrst.changeDate BETWEEN :startDate AND :endDate")
  Page<MerchantStatusSuspension> findAllByChangeDateBetween(
      Date startDate, Date endDate, Pageable pageable);

  List<MerchantStatusSuspension> findByMerchantOrderByChangeDateDesc(Merchant merchant);
}
