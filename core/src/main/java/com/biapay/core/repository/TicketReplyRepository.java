package com.biapay.core.repository;

import com.biapay.core.model.TicketReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketReplyRepository extends JpaRepository<TicketReply, Long> {

  //  List<TicketReply> findByticketNo(Ticket ticketNo);
}
