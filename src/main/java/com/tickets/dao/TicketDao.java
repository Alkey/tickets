package com.tickets.dao;

import com.tickets.model.Status;
import com.tickets.model.Ticket;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findFirstByStatus(Status status);
}
