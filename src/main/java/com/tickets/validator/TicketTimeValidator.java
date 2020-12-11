package com.tickets.validator;

import com.tickets.dto.TicketRequestDto;
import com.tickets.exception.IncorrectDateException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class TicketTimeValidator {
    public LocalDateTime validate(TicketRequestDto dto) {
        LocalDateTime ticketTime = LocalDateTime.parse(dto.getTime(),
                DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        if (ticketTime.isAfter(LocalDateTime.now())) {
            return ticketTime;
        } else {
            throw new IncorrectDateException("Incorrect date");
        }
    }
}
