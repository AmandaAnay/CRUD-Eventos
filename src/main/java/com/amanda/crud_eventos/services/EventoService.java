package com.amanda.crud_eventos.services;

import com.amanda.crud_eventos.dto.EventoDTO;
import com.amanda.crud_eventos.models.Evento;
import com.amanda.crud_eventos.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Transactional(readOnly = true)
    public Page<EventoDTO> findAllPaged(PageRequest pageRequest) {
        Page<Evento> list = eventoRepository.findAll(pageRequest);
        return list.map(EventoDTO::new);
    }

    @Transactional
    public EventoDTO insert(EventoDTO dto) {
        Evento entity = new Evento();
        entity.setName(dto.getName());
        entity.setDescricao(dto.getDescricao());
        entity.setHorarioInicio(dto.getHorarioInicio());
        entity.setHorarioTermino(dto.getHorarioTermino());
        entity = eventoRepository.save(entity);
        return new EventoDTO(entity);
    }

    @Transactional
    public EventoDTO update(Long id, EventoDTO dto) {
        try {
            Evento entity = eventoRepository.getById(id);
            entity.setName(dto.getName());
            entity.setDescricao(dto.getDescricao());
            entity.setHorarioInicio(dto.getHorarioInicio());
            entity.setHorarioTermino(dto.getHorarioTermino());
            entity = eventoRepository.save(entity);
            return new EventoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            eventoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Integrity violation");
        }
    }
}
