package com.jpllopes96.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jpllopes96.helpdesk.domain.enums.Priority;
import com.jpllopes96.helpdesk.domain.enums.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate creationDate = LocalDate.now();

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate closeDate;
    private Priority priority;
    private Status status;
    private String title;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "tec_id")
    private Tec tec;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Ticket(){
        super();
    }

    public Ticket(Integer id, Priority priority, Status status, String title, String notes, Tec tec, Client client) {

        this.id = id;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.notes = notes;
        this.tec = tec;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Tec getTec() {
        return tec;
    }

    public void setTec(Tec tec) {
        this.tec = tec;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(getId(), ticket.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
