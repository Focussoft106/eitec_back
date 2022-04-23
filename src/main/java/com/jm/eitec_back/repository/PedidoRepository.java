package com.jm.eitec_back.repository;

import com.jm.eitec_back.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
