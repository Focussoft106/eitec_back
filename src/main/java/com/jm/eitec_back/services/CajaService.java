package com.jm.eitec_back.services;

import com.jm.eitec_back.entity.Caja;
import com.jm.eitec_back.implement.CajaImpl;
import com.jm.eitec_back.repository.CajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CajaService implements CajaImpl {
    @Autowired
    private CajaRepository cajaRepository;

    @Override
    public void save(Caja caja) {
        cajaRepository.save(caja);
    }

    @Override
    public Caja findById(Long id) {
        return cajaRepository.findById(id).get();
    }

    @Override
    public List<Caja> listAll() {
        return cajaRepository.findAll();
    }
}
