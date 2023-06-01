package com.jpllopes96.helpdesk.resources;

import com.jpllopes96.helpdesk.domain.Ticket;
import com.jpllopes96.helpdesk.domain.dtos.TicketDTO;
import com.jpllopes96.helpdesk.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TicketDTO> findById(@PathVariable Integer id){
        Ticket obj = ticketService.findById(id);
        return ResponseEntity.ok().body(new TicketDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<TicketDTO>> findAll(){
        List<Ticket> list = ticketService.findAll();
        List<TicketDTO> listDTO = list.stream().map(obj -> new TicketDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TicketDTO> create(@Valid @RequestBody TicketDTO objDTO){
        Ticket obj = ticketService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TicketDTO> update(@Valid @PathVariable Integer id, @RequestBody TicketDTO objDTO){
        Ticket newObj = ticketService.update(id, objDTO);
        return ResponseEntity.ok().body(new TicketDTO(newObj));

    }
}
