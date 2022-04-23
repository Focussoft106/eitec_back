package com.jm.eitec_back.implement;

import com.jm.eitec_back.entity.Caja;

import java.util.List;

public interface CajaImpl {
    void  save(Caja caja);

    Caja findById(Long id);

    List<Caja> listAll();
}
