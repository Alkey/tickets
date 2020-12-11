package com.tickets;

import com.tickets.dto.TicketRequestDto;
import com.tickets.mapper.TicketMapper;
import com.tickets.model.Status;
import com.tickets.model.Ticket;
import com.tickets.validator.TicketTimeValidator;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class TicketMapperTest {
    private static TicketMapper mapper;
    private static final TicketTimeValidator validator = Mockito.mock(TicketTimeValidator.class);

    @BeforeAll
    public static void init() {
        mapper = new TicketMapper(validator);
    }

    @Test
    public void checkMappingDtoToTicket() {
        Ticket ticket = new Ticket();
        ticket.setNumber("1");
        ticket.setTime(LocalDateTime.of(2020, 12, 14, 10, 15, 30));
        ticket.setStatus(Status.IN_PROGRESS);
        TicketRequestDto dto = new TicketRequestDto();
        dto.setNumber("1");
        dto.setTime("2020-12-14T10:15:30");
        Mockito.when(validator.validate(dto))
                .thenReturn(LocalDateTime.of(2020, 12, 14, 10, 15, 30));
        assertEquals(mapper.getTicket(dto), ticket);
    }
}
