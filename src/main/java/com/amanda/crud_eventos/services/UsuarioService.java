package com.amanda.crud_eventos.services;

import com.amanda.crud_eventos.dto.EventoDTO;
import com.amanda.crud_eventos.dto.UsuarioDTO;
import com.amanda.crud_eventos.models.Evento;
import com.amanda.crud_eventos.models.Usuario;
import com.amanda.crud_eventos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Page<UsuarioDTO> findAllPaged(PageRequest pageRequest) {
        Page<Usuario> list = usuarioRepository.findAll(pageRequest);
        return list.map(UsuarioDTO::new);
    }

    @Transactional
    public UsuarioDTO insert(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setLogin(dto.getLogin());
        entity.setSenha(dto.getSenha());
        entity = usuarioRepository.save(entity);
        return new UsuarioDTO(entity);
    }

    @Transactional
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        try {
            Usuario entity = usuarioRepository.getById(id);
            entity.setId(dto.getId());
            entity.setLogin(dto.getLogin());
            entity.setSenha(dto.getSenha());
            entity = usuarioRepository.save(entity);
            return new UsuarioDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Integrity violation");
        }
    }
}


