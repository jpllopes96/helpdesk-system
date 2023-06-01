package com.jpllopes96.helpdesk.resources;

import com.jpllopes96.helpdesk.domain.Ticket;
import com.jpllopes96.helpdesk.domain.dtos.TicketDTO;
import com.jpllopes96.helpdesk.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TicketDTO> findById(@PathVariable Integer id){
        Ticket obj = ticketService.findById(id);
        return ResponseEntity.ok().body(new TicketDTO(obj));
    }
}
