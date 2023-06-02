package com.jpllopes96.helpdesk.services;

import com.jpllopes96.helpdesk.domain.Person;
import com.jpllopes96.helpdesk.domain.Client;
import com.jpllopes96.helpdesk.domain.dtos.ClientDTO;
import com.jpllopes96.helpdesk.repositories.ClientRepository;
import com.jpllopes96.helpdesk.repositories.PersonRepository;
import com.jpllopes96.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.jpllopes96.helpdesk.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Client findById(Integer id){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Client not found! Id: "+ id));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client create(ClientDTO objDTO) {
        objDTO.setId(null);
        objDTO.setPassword(encoder.encode(objDTO.getPassword()));
        validateByCPFAndEmail(objDTO);
        Client newObj = new Client(objDTO);
        return clientRepository.save(newObj);
    }

    public Client update(Integer id, @Valid ClientDTO objDTO) {
        objDTO.setId(id);
        Client oldObj = findById(id);
        validateByCPFAndEmail(objDTO);
        oldObj = new Client(objDTO);
        return clientRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Client obj = findById(id);
        if (obj.getTickets().size() > 0){
            throw new DataIntegrityViolationException("Client cannot be deleted, because it has Tickets");
        }else {
            clientRepository.deleteById(id);
        }
    }
    private void validateByCPFAndEmail(ClientDTO objDTO) {
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
