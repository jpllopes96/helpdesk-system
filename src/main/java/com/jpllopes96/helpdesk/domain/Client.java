package com.jpllopes96.helpdesk.domain;

import com.jpllopes96.helpdesk.domain.enums.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends Person{

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets = new ArrayList<>();

    public Client(){
        super();
        setProfile(Profile.CLIENT);
    }

    public Client(Integer id, String name, String cpf, String email, String password, List<Ticket> tickets) {
        super(id, name, cpf, email, password);
        setProfile(Profile.CLIENT);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
