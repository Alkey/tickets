package com.tickets.service;

import com.tickets.model.Ticket;
import java.util.Optional;

public interface TicketService {
    Long save(Ticket ticket);

    String getStatus(Long id);

    Optional<Ticket> getWithInProcessStatus();
}
