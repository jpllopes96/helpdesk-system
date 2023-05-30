package com.jpllopes96.helpdesk.services;

import com.jpllopes96.helpdesk.domain.Client;
import com.jpllopes96.helpdesk.domain.Tec;
import com.jpllopes96.helpdesk.domain.Ticket;
import com.jpllopes96.helpdesk.domain.enums.Priority;
import com.jpllopes96.helpdesk.domain.enums.Profile;
import com.jpllopes96.helpdesk.domain.enums.Status;
import com.jpllopes96.helpdesk.repositories.ClientRepository;
import com.jpllopes96.helpdesk.repositories.TecRepository;
import com.jpllopes96.helpdesk.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TecRepository tecRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    TicketRepository ticketRepository;

    public void dbInstance(){
        Tec tec1 = new Tec(null, "Valdir Cezar", "12345623470", "valdir@email.com", "123");
        tec1.setProfile(Profile.ADMIN);

        Client cli1 = new Client(null, "Linus Tovarlds", "12333344409", "torvalds@email.com", "123");

        Ticket t1 = new Ticket(null, Priority.MEDIUM, Status.PROGRESS, "Case 01", "First case", tec1, cli1);

        tecRepository.saveAll(Arrays.asList(tec1));
        clientRepository.saveAll(Arrays.asList(cli1));
        ticketRepository.saveAll(Arrays.asList(t1));
    }

}
