package com.julia.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.julia.core.model.Evento;
import com.julia.core.service.interfaces.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;
    
    @PostMapping
    public ResponseEntity<Evento> save(@RequestBody Evento object){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.eventoService.save(object));
    }

    @GetMapping
    public ResponseEntity<List<Evento>> list(){
        return ResponseEntity.ok().body(this.eventoService.list());
    }

}
