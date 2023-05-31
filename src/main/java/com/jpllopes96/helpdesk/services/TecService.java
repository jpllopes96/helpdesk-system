package com.jpllopes96.helpdesk.services;

import com.jpllopes96.helpdesk.domain.Person;
import com.jpllopes96.helpdesk.domain.Tec;
import com.jpllopes96.helpdesk.domain.dtos.TecDTO;
import com.jpllopes96.helpdesk.repositories.PersonRepository;
import com.jpllopes96.helpdesk.repositories.TecRepository;
import com.jpllopes96.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.jpllopes96.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecService {

    @Autowired
    private TecRepository tecRepository;

    @Autowired
    private PersonRepository personRepository;

    public Tec findById(Integer id){
        Optional<Tec> obj = tecRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Tec not found! Id: "+ id));
    }

    public List<Tec> findAll() {
        return tecRepository.findAll();
    }

    public Tec create(TecDTO objDTO) {
        objDTO.setId(null);
        validateByCPFAndEmail(objDTO);
        Tec newObj = new Tec(objDTO);
        return tecRepository.save(newObj);
    }

    private void validateByCPFAndEmail(TecDTO objDTO) {
        Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("CPF is already in use!");
        }
        obj = personRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("E-mail is already in use!");
        }

    }
}
