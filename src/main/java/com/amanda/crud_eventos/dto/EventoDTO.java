package com.amanda.crud_eventos.dto;

import com.amanda.crud_eventos.models.Evento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EventoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String descricao;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime horarioInicio;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime horarioTermino;


    public EventoDTO(Evento entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.descricao = entity.getDescricao();
        this.horarioInicio = entity.getHorarioInicio();
        this.horarioTermino = entity.getHorarioTermino();
    }

}

