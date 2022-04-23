package com.jm.eitec_back.rest;

import java.util.List;

import com.jm.eitec_back.entity.Caja;
import com.jm.eitec_back.services.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/caja")
@CrossOrigin(origins = "*")
public class CajaRest {

    @Autowired
    private CajaService cajaService;

    @PostMapping("/registrar")
    public String guardar(@RequestBody Caja caja) {
        cajaService.save(caja);
        return "El registro se guardo con exito";
    }

    @GetMapping("/listar")
    public List<Caja> listar(){
        return cajaService.listAll();
    }
}
