package com.jpllopes96.helpdesk.repositories;

import com.jpllopes96.helpdesk.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
