package com.jpllopes96.helpdesk.services;

import com.jpllopes96.helpdesk.domain.Tec;
import com.jpllopes96.helpdesk.repositories.TecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecService {

    @Autowired
    private TecRepository tecRepository;

    public Tec findById(Integer id){
        Optional<Tec> obj = tecRepository.findById(id);
        return obj.orElse(null);
    }
}
