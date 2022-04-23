package com.jm.eitec_back.rest;

import com.jm.eitec_back.entity.Usuario;
import com.jm.eitec_back.services.UsuarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/usuario")
@CrossOrigin(origins = "*")
public class UsuarioRest {


    private UsuarioService usuarioService;

    @GetMapping("/listaEnvios/{id}")
    public Usuario porEntregar(@PathVariable Long id){


        try {

            return usuarioService.findById(id);

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
}
