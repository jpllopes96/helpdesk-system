package com.jpllopes96.helpdesk.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jpllopes96.helpdesk.domain.Tec;
import com.jpllopes96.helpdesk.domain.enums.Profile;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TecDTO implements Serializable {
    protected Integer id;
    protected String name;
    protected String cpf;
    protected String email;
    protected String password;
    protected Set<Integer> profiles = new HashSet<>();
    @JsonFormat(pattern = "MM/dd/yyyy")
    protected LocalDate creationDate = LocalDate.now();

    public TecDTO(){
        super();
    }

    public TecDTO(Tec obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
        this.creationDate = obj.getCreationDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void setProfiles(Profile profile) {
        this.profiles.add(profile.getCode());
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
