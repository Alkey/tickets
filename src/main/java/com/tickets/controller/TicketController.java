package com.tickets.controller;

import com.tickets.dto.TicketRequestDto;
import com.tickets.mapper.TicketMapper;
import com.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService service;
    private final TicketMapper mapper;

    @PostMapping
    public Long saveTicket(@RequestBody TicketRequestDto dto) {
        return service.save(mapper.getTicket(dto));
    }

    @GetMapping("/{id}")
    public String getStatus(@PathVariable Long id) {
        return service.getStatus(id);
    }
}
