package com.jpllopes96.helpdesk.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jpllopes96.helpdesk.domain.Ticket;

import java.io.Serializable;
import java.time.LocalDate;

public class TicketDTO implements Serializable {

    private Integer id;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate creationDate = LocalDate.now();

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate closeDate;
    private Integer priority;
    private Integer status;
    private String title;
    private String notes;
    private Integer tec;
    private Integer client;
    private String tecName;
    private String clientName;

    public TicketDTO(){
        super();
    }

    public TicketDTO(Ticket obj) {
        this.id = obj.getId();
        this.creationDate = obj.getCreationDate();
        this.closeDate = obj.getCloseDate();
        this.priority = obj.getPriority().getCode();
        this.status = obj.getStatus().getCode();
        this.title = obj.getTitle();
        this.notes = obj.getNotes();
        this.tec = obj.getTec().getId();
        this.client = obj.getClient().getId();
        this.tecName = obj.getTec().getName();
        this.clientName = obj.getClient().getName();
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public Integer getTec() {
        return tec;
    }

    public void setTec(Integer tec) {
        this.tec = tec;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getTecName() {
        return tecName;
    }

    public void setTecName(String tecName) {
        this.tecName = tecName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
