package com.jm.eitec_back.services;

import com.jm.eitec_back.entity.Pedido;
import com.jm.eitec_back.implement.PdidoImpl;
import com.jm.eitec_back.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoService implements PdidoImpl {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).get();
    }
}
