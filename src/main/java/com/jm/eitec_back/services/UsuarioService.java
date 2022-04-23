package com.jm.eitec_back.services;

import com.jm.eitec_back.entity.Usuario;
import com.jm.eitec_back.implement.UsuarioImpl;
import com.jm.eitec_back.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService implements UsuarioImpl {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
