package com.jpllopes96.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person{

    private List<Ticket> tickets = new ArrayList<>();

    public Client(){
        super();
    }

    public Client(Integer id, String name, String cpf, String email, String password, List<Ticket> tickets) {
        super(id, name, cpf, email, password);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
