package com.tickets.mapper;

import com.tickets.dto.TicketRequestDto;
import com.tickets.model.Status;
import com.tickets.model.Ticket;
import com.tickets.validator.TicketTimeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketMapper {
    private static final Status DEFAULT_STATUS = Status.IN_PROGRESS;
    private final TicketTimeValidator validator;

    public Ticket getTicket(TicketRequestDto dto) {
        Ticket ticket = new Ticket();
        ticket.setNumber(dto.getNumber());
        ticket.setTime(validator.validate(dto));
        ticket.setStatus(DEFAULT_STATUS);
        return ticket;
    }
}
