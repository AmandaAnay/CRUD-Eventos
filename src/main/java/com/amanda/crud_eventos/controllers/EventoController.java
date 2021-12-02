package com.amanda.crud_eventos.controllers;

import com.amanda.crud_eventos.models.Evento;
import com.amanda.crud_eventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/eventos" )
public class EventoController {

    @Autowired
    EventoService eventoService;

    @PostMapping
    public ResponseEntity<Evento> criar(@RequestBody Evento dto) {
        dto = eventoService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}

