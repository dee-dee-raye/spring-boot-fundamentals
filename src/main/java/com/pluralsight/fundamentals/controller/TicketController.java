package com.pluralsight.fundamentals.controller;

import com.pluralsight.fundamentals.entity.Ticket;
import com.pluralsight.fundamentals.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Ticket> getTickets() {
        System.out.println("Here");
        return ticketService.listTickets();
    }

}
