package com.jm.eitec_back.implement;

import com.jm.eitec_back.entity.Usuario;

public interface UsuarioImpl {


    Usuario findById(Long id);

    void save(Usuario usuario);
}
