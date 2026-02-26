package com.spring.notaventa.Repository;

import com.spring.notaventa.Model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Integer> {
    List<DetallePedido> findByPedidoIdPedido(Integer id);
}
