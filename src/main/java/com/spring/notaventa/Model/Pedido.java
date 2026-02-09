package com.spring.notaventa.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    public Pedido() {
    }

    public Integer getId_pedido() {
        return id_pedido;
    }
}
