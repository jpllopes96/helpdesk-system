package com.jpllopes96.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpllopes96.helpdesk.domain.dtos.TecDTO;
import com.jpllopes96.helpdesk.domain.enums.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Tec extends Person{

    @JsonIgnore
    @OneToMany(mappedBy = "tec")
    private List<Ticket> tickets = new ArrayList<>();

    public Tec(){
        super();
        setProfile(Profile.CLIENT);
    }
    public Tec(TecDTO obj){
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
        this.creationDate = obj.getCreationDate();
    }
    public Tec(Integer id, String name, String cpf, String email, String password) {
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
