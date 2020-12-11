package com.tickets;

import com.tickets.dto.TicketRequestDto;
import com.tickets.validator.TicketTimeValidator;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TicketTimeValidatorTest {
    private static TicketTimeValidator validator;

    @BeforeAll
    public static void init() {
        validator = new TicketTimeValidator();
    }

    @Test
    public void checkWithCorrectDate() {
        LocalDateTime expected = LocalDateTime.now().plusDays(1L);
        TicketRequestDto dto = new TicketRequestDto();
        dto.setNumber("1");
        dto.setTime(expected.toString());
        assertEquals(validator.validate(dto), expected);
    }

    @Test
    public void checkWithIncorrectDate() {
        TicketRequestDto dto = new TicketRequestDto();
        dto.setTime(LocalDateTime.now().minusDays(1L).toString());
        assertThrows(RuntimeException.class,() -> validator.validate(dto));
    }
}
