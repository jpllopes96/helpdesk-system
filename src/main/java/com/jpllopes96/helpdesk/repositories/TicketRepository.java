package com.jpllopes96.helpdesk.repositories;

import com.jpllopes96.helpdesk.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
