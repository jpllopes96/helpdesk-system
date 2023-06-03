package com.jpllopes96.helpdesk.resources;

import com.jpllopes96.helpdesk.domain.Tec;
import com.jpllopes96.helpdesk.domain.dtos.TecDTO;
import com.jpllopes96.helpdesk.services.TecService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/technics")
public class TecResource {

    @Autowired
    private TecService service;

    //localhost:8080/technics/1
    @GetMapping(value = "/{id}")
    public ResponseEntity<TecDTO> findById(@PathVariable Integer id){
        Tec obj = service.findById(id);
        return  ResponseEntity.ok().body(new TecDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<TecDTO>> findAll(){
        List<Tec> list = service.findAll();
        List<TecDTO> listDTO = list.stream().map(x -> new TecDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<TecDTO> create(@Valid @RequestBody TecDTO objDTO){
        Tec newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public  ResponseEntity<TecDTO> update(@PathVariable Integer id, @Valid @RequestBody TecDTO objDTO){
        Tec obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new TecDTO(obj));

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TecDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
