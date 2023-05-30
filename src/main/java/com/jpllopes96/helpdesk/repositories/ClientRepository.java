package com.jpllopes96.helpdesk.repositories;

import com.jpllopes96.helpdesk.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
