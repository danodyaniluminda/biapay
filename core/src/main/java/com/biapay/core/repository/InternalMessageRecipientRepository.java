package com.biapay.core.repository;

import com.biapay.core.model.InternalMessageRecipient;
import com.biapay.core.model.enums.ImStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface InternalMessageRecipientRepository
    extends JpaRepository<InternalMessageRecipient, Long> {

  List<InternalMessageRecipient> findAllByStatus(ImStatus status);

  List<InternalMessageRecipient> findByMessageId(Long messageId);

  List<InternalMessageRecipient> findByRecipientIdAndStatus(Long recipientId, ImStatus status);

  Optional<InternalMessageRecipient> findByRecipientIdAndMessageIdAndStatus(
      Long recipientId, Long messageId, ImStatus status);

  @Modifying
  @Query("delete from InternalMessageRecipient where messageId=:messageId")
  int deleteByMessageId(Long messageId);
}
