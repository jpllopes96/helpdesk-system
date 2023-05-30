package com.jpllopes96.helpdesk.resources;

import com.jpllopes96.helpdesk.domain.Tec;
import com.jpllopes96.helpdesk.services.TecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/technics")
public class TecResource {

    @Autowired
    private TecService service;

    //localhost:8080/technics/1
    @GetMapping(value = "/{id}")
    public ResponseEntity<Tec> findById(@PathVariable Integer id){
        Tec obj = service.findById(id);
        return  ResponseEntity.ok().body(obj);
    }
}
