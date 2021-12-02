package com.amanda.crud_eventos.dto;

import com.amanda.crud_eventos.models.Evento;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class EventoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioTermino;


    public EventoDTO(Evento entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.horarioInicio = entity.getHorarioInicio();
        this.horarioTermino = entity.getHorarioTermino();
    }

}

