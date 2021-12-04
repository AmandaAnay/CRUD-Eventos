package com.amanda.crud_eventos.dto;

import com.amanda.crud_eventos.models.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;

    public UsuarioDTO(Usuario entity) {
        this.id = entity.getId();
        this.login = entity.getLogin();
        this.senha = entity.getSenha();
    }

}
