package com.jpllopes96.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpllopes96.helpdesk.domain.enums.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tec extends Person{

    @JsonIgnore
    @OneToMany(mappedBy = "tec")
    private List<Ticket> tickets = new ArrayList<>();

    public Tec(){
        super();
        setProfile(Profile.TEC);
    }
    public Tec(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        setProfile(Profile.TEC);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
