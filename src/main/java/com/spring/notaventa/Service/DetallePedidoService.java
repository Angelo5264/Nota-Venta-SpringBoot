package com.spring.notaventa.Service;

import com.spring.notaventa.Model.DetallePedido;
import com.spring.notaventa.Model.Pedido;
import com.spring.notaventa.Model.Producto;
import com.spring.notaventa.Repository.DetallePedidoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DetallePedidoService {
    private final DetallePedidoRepository repository;
    private final ProductoService productoService;
    private final PedidoService pedidoService;

    public DetallePedidoService(DetallePedidoRepository repository, ProductoService productoService, PedidoService pedidoService) {
        this.repository = repository;
        this.productoService = productoService;
        this.pedidoService = pedidoService;
    }

    public void crearDetallePedido(Integer idPedido, Integer idProducto, Integer cantidad){
        Pedido pedido = pedidoService.buscarPedidoOpt(idPedido).orElseThrow(
                ()-> new RuntimeException("Pedido no encontrado")
        );
        Producto producto = productoService.buscarProductoOpt(idProducto).orElseThrow(
                ()-> new RuntimeException("Producto no encontrado")
        );
        DetallePedido detallePedido =new DetallePedido(pedido,producto,cantidad);
        repository.save(detallePedido);
    }

    public List<DetallePedido> buscarDetallePedidoPorIdPedido(Integer id){
        return repository.findByPedido_Id_pedido(id);
    }

    public BigDecimal totalPedido(Integer idPedido){
        BigDecimal total = BigDecimal.ZERO;
        List<DetallePedido> pedidosList = buscarDetallePedidoPorIdPedido(idPedido);
        for (DetallePedido detalle : pedidosList){
            BigDecimal cantidad = BigDecimal.valueOf(detalle.getCantidad());
            BigDecimal precio = detalle.getProducto().getPrecio();
            BigDecimal subtotal = precio.multiply(cantidad);
            total= total.add(subtotal);
        }
        return total;
    }
}
