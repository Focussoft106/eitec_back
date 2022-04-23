package com.jm.eitec_back.implement;

import com.jm.eitec_back.entity.Pedido;

import java.util.List;

public interface PdidoImpl {
    void save(Pedido pedido);

    List<Pedido> listAll();

    Pedido findById(Long id);
}
