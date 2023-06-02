package com.jpllopes96.helpdesk.services;

import com.jpllopes96.helpdesk.domain.Client;
import com.jpllopes96.helpdesk.domain.Tec;
import com.jpllopes96.helpdesk.domain.Ticket;
import com.jpllopes96.helpdesk.domain.enums.Priority;
import com.jpllopes96.helpdesk.domain.enums.Profile;
import com.jpllopes96.helpdesk.domain.enums.Status;
import com.jpllopes96.helpdesk.repositories.ClientRepository;
import com.jpllopes96.helpdesk.repositories.PersonRepository;
import com.jpllopes96.helpdesk.repositories.TecRepository;
import com.jpllopes96.helpdesk.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void dbInstance(){
        Tec tec1 = new Tec(null, "Valdir Cezar", "550.482.150-95", "valdir@mail.com", encoder.encode("123"));
        tec1.setProfile(Profile.ADMIN);
        Tec tec2 = new Tec(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", encoder.encode("123"));
        Tec tec3 = new Tec(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", encoder.encode("123"));
        Tec tec4 = new Tec(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", encoder.encode("123"));
        Tec tec5 = new Tec(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", encoder.encode("123"));

        Client cli1 = new Client(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", encoder.encode("123"));
        Client cli2 = new Client(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
        Client cli3 = new Client(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"));
        Client cli4 = new Client(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
        Client cli5 = new Client(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));

        Ticket c1 = new Ticket(null, Priority.MEDIUM, Status.PROGRESS, "Ticket 1", "Test Ticket 1", tec1, cli1);
        Ticket c2 = new Ticket(null, Priority.HIGH, Status.OPEN, "Ticket 2", "Test Ticket 2", tec1, cli2);
        Ticket c3 = new Ticket(null, Priority.LOW, Status.DONE, "Ticket 3", "Test Ticket 3", tec2, cli3);
        Ticket c4 = new Ticket(null, Priority.HIGH, Status.OPEN, "Ticket 4", "Test Ticket 4", tec3, cli3);
        Ticket c5 = new Ticket(null, Priority.MEDIUM, Status.PROGRESS, "Ticket 5", "Test Ticket 5", tec2, cli1);
        Ticket c6 = new Ticket(null, Priority.LOW, Status.DONE, "Chamado 7", "Test chamado 6", tec1, cli5);

        personRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
        ticketRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

    }

}
