package com.jpllopes96.helpdesk.services;

import com.jpllopes96.helpdesk.domain.Client;
import com.jpllopes96.helpdesk.domain.Tec;
import com.jpllopes96.helpdesk.domain.Ticket;
import com.jpllopes96.helpdesk.domain.dtos.TicketDTO;
import com.jpllopes96.helpdesk.domain.enums.Priority;
import com.jpllopes96.helpdesk.domain.enums.Status;
import com.jpllopes96.helpdesk.repositories.TicketRepository;
import com.jpllopes96.helpdesk.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TecService tecService;

    @Autowired
    private ClientService clientService;

    public Ticket findById(Integer id){
        Optional<Ticket> obj = ticketRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Ticket not found! Id: " + id));
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket create(@Valid TicketDTO objDTO) {
        return ticketRepository.save(newTicket(objDTO));
    }

    private Ticket newTicket(TicketDTO obj){

        Tec tec = tecService.findById(obj.getTec());
        Client client = clientService.findById(obj.getClient());

        Ticket ticket = new Ticket();
        if(obj.getId() != null){
            ticket.setId(obj.getId());
        }

        ticket.setTec(tec);
        ticket.setClient(client);
        ticket.setPriority(Priority.toEnum(obj.getPriority()));
        ticket.setStatus((Status.toEnum(obj.getStatus())));
        ticket.setTitle(obj.getTitle());
        ticket.setNotes(obj.getNotes());
        return ticket;


    }
}
