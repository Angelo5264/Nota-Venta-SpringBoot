package com.spring.notaventa.Service;

import com.spring.notaventa.Model.Producto;
import com.spring.notaventa.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements Existencia {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }

    public Integer crearProducto(Producto producto){
        Producto productoCreado = productoRepository.save(producto);
        return productoCreado.getId_producto();
    }

    public Optional<Producto> buscarProductoOpt(Integer id){
        return productoRepository.findById(id);
    }

    public Producto buscarProducto(Integer id){
        try{
            Optional<Producto> productoOptional= productoRepository.findById(id);
            return productoOptional.orElseThrow(
                    ()->new RuntimeException("Error producto no encontrado")
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar" + e.getMessage());
        }
    }

    public String eliminarProducto(Integer id){
            Producto producto = buscarProducto(id);
            productoRepository.delete(producto);
            return "Producto Eliminado";
    }

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    @Override
    public boolean existencia(Integer id) {
        return productoRepository.existsById(id);
    }
}
