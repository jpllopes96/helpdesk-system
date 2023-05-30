package com.jpllopes96.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jpllopes96.helpdesk.domain.enums.Profile;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public abstract class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String name;

    @Column(unique = true)
    protected String cpf;

    @Column(unique = true)
    protected String email;
    protected String password;

    //coleção do tipo integer garantir que a lista de perfil vem junto com o usuário
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PROFILES")
    protected Set<Integer> profiles = new HashSet<>();

    @JsonFormat(pattern = "MM/dd/yyyy")
    protected LocalDate creationDate = LocalDate.now();

    public Person(){
        super();
        setProfile(Profile.CLIENT);
    }

    public Person(Integer id, String name, String cpf, String email, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        setProfile(Profile.CLIENT);
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

    public void setProfile(Profile profile) {
        this.profiles.add(profile.getCode());
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getCpf(), person.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf());
    }
}
