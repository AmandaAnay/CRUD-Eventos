package com.amanda.crud_eventos.models;

import com.amanda.crud_eventos.dto.EventoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String descricao;

    @Column(name = "horario_inicio")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime horarioInicio;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "horario_termino")
    private LocalDateTime horarioTermino;

    public Evento(EventoDTO eventoDTO) {
        this.id = eventoDTO.getId();
        this.name = eventoDTO.getName();
        this.descricao = eventoDTO.getDescricao();
        this.horarioInicio = eventoDTO.getHorarioInicio();
        this.horarioTermino = eventoDTO.getHorarioTermino();
    }


}
