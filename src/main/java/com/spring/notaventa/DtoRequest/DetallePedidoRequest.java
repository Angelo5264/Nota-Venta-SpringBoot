package com.spring.notaventa.DtoRequest;

public class DetallePedidoRequest {
    private Integer idPedido;
    private Integer idProducto;
    private Integer cantidad;

    public DetallePedidoRequest() {
    }

    public DetallePedidoRequest(Integer idPedido, Integer idProducto, Integer cantidad) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
