package com.biapay.core.repository;

import com.biapay.core.model.UserDevice;
import com.biapay.core.model.UserDevice.Status;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {

  List<UserDevice> findAllByTokenAndStatusAndCreatedAtGreaterThan(
      String tokenHash, Status status, Instant createdAt);

  UserDevice findByTokenAndStatusAndCreatedAtGreaterThan(
      String tokenHash, Status status, Instant createdAt);

  List<UserDevice> findAllByUserId(String userId);

  List<UserDevice> findAllByUserIdAndStatusNot(String userId, Status status);

  List<UserDevice> findAllByUserIdAndStatus(String userId, Status status);

  List<UserDevice> findAllByPhoneNumberAndStatus(String phoneNumber, Status status);

  UserDevice findByPhoneNumberAndStatus(String phoneNumber, Status status);

  List<UserDevice> findAllByDeviceIdAndStatus(String phoneNumber, Status status);

  UserDevice findByUserIdAndStatus(String userId, Status status);

  List<UserDevice> findAllByStatus(Status status);

  Optional<UserDevice> findById(Integer id);

  List<UserDevice> findAllByDeviceIdAndStatusAndUserId(
      String deviceId, Status status, String userId);

  List<UserDevice> findFirstByTokenAndStatusAndCreatedAtGreaterThan(
      String tokenHash, Status status, LocalDateTime createdAt);

  @Query(
      value =
          "from UserDevice ud where ud.token = :tokenHash and ud.status = :status and :expiryDate <= ud.expiryDate order by ud.createdAt desc")
  List<UserDevice> findAllByTokenAndStatusAndExpiryDateLessThanEqual(
      String tokenHash, Status status, LocalDateTime expiryDate);

  //  UserDevice findFirstByTokenAndStatusAndCreatedAtBetween(
  //      String tokenHash, Status status, Instant createdAt);
}
