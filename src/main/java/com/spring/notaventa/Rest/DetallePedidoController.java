package com.spring.notaventa.Rest;

import com.spring.notaventa.DtoRequest.DetallePedidoRequest;
import com.spring.notaventa.Service.DetallePedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detallePedido")
public class DetallePedidoController {
    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @PostMapping
    public ResponseEntity<String> crearDetallePedido(@RequestBody DetallePedidoRequest request){
        detallePedidoService.crearDetallePedido(request.getIdPedido(),request.getIdProducto(),request.getCantidad());
        return ResponseEntity.status(201).body("Detalle Creado correctamente");
    }

    


}
