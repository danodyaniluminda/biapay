package com.biapay.core.repository;

import com.biapay.core.model.BarCodePaymentPushNotification;
import com.biapay.core.model.ClientTransaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarCodePaymentPushNotificationRepository
    extends JpaRepository<BarCodePaymentPushNotification, Long> {
  List<BarCodePaymentPushNotification> findByClientTransaction(ClientTransaction clientTransaction);
}
