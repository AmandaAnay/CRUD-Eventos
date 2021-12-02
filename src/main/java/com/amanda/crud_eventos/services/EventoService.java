package com.amanda.crud_eventos.services;

import com.amanda.crud_eventos.models.Evento;
import com.amanda.crud_eventos.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;

    public Evento insert(Evento dto) {
       return eventoRepository.save(dto);

    }
}
