package com.spring.notaventa.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    public Pedido() {
    }

    public Integer getIdPedido() {
        return idPedido;
    }
}
