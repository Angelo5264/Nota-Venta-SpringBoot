package com.spring.notaventa.Rest;

import com.spring.notaventa.Model.Producto;
import com.spring.notaventa.Service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Integer crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }
    @GetMapping
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto buscarProducto(@PathVariable Integer id){
        return productoService.buscarProducto(id);
    }
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);
        return "Producto eliminado";
    }


}
