package com.biapay.core.repository;

import com.biapay.core.model.Ticket;
import com.biapay.core.model.TicketStatus;
import com.biapay.core.model.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
  List<Ticket> findAllByCreatedUser(User createdUser);

  List<Ticket> findAllByCreatedUserOrderByCreatedDateDesc(User createdUser);

  List<Ticket> findAllByCreatedUserOrAssigneesContainsOrderByCreatedDateDesc(
      User createdUser, User assigneeUser);

  Optional<Ticket> findTicketByTicketNo(String ticketNo);

  List<Ticket> findAllByOrderByCreatedDateDesc();

  List<Ticket> findAllByStatusOrderByCreatedDateDesc(TicketStatus ticketStatus);

  List<Ticket> findAllByStatusAndCreatedUserOrderByCreatedDateDesc(
      TicketStatus ticketStatus, User user);

  List<Ticket> findAllByCreatedDateBetweenOrderByCreatedDateDesc(
      LocalDateTime from, LocalDateTime to);

  List<Ticket> findAllByCreatedUserAndCreatedDateBetweenOrderByCreatedDateDesc(
      User user, LocalDateTime from, LocalDateTime to);

  Page<Ticket> findAllByCreatedUserOrAssigneesContains(User createdUser, User assignee, Pageable pageable);
  Page<Ticket> findAll(Pageable pageable);

}
