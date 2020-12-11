package com.tickets.service;

import com.tickets.dao.TicketDao;
import com.tickets.model.Status;
import com.tickets.model.Ticket;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketDao dao;

    @Override
    public Long save(Ticket ticket) {
        return dao.save(ticket).getId();
    }

    @Override
    public String getStatus(Long id) {
        return dao.getOne(id).getStatus().name();
    }

    @Override
    public Optional<Ticket> getWithInProcessStatus() {
        return dao.findFirstByStatus(Status.IN_PROGRESS);
    }
}
