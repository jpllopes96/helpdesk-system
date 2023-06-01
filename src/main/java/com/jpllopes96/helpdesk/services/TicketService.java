package com.jpllopes96.helpdesk.services;

import com.jpllopes96.helpdesk.domain.Ticket;
import com.jpllopes96.helpdesk.repositories.TicketRepository;
import com.jpllopes96.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket findById(Integer id){
        Optional<Ticket> obj = ticketRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Ticket not found! Id: " + id));
    }

}
