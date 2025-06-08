package com.biapay.core.repository;

import com.biapay.core.model.InternalMessage;
import com.biapay.core.model.enums.ImStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalMessageRepository extends JpaRepository<InternalMessage, Long> {

  List<InternalMessage> findAllByStatus(ImStatus status);

  InternalMessage findBySubject(String groupId);
}
