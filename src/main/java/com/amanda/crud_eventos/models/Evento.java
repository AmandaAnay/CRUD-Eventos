package com.amanda.crud_eventos.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String descricao;
    @Column(name = "horario_inicio")
    private LocalDateTime horarioInicio;
    @Column(name = "horario_termino")
    private LocalDateTime horarioTermino;


}
