package com.tickets.service;

import com.tickets.model.Status;
import com.tickets.model.Ticket;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketProcessor {
    private final TicketService service;

    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void changeStatus() {
        Optional<Ticket> optionalTicket = service.getWithInProcessStatus();
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setStatus(Status.parse(new Random().nextInt(2)));
            service.save(ticket);
        }
    }
}
