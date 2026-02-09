package com.spring.notaventa.Service;

import com.spring.notaventa.Model.Pedido;
import com.spring.notaventa.Repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements Existencia{
    private final PedidoRepository repository;


    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido crearPedido(){
        Pedido pedido = new Pedido();
        return repository.save(pedido);
    }
    public Optional<Pedido> buscarPedidoOpt(Integer id){
        return repository.findById(id);
    }
    public Pedido buscarPedido(Integer id){
        try {
            Optional<Pedido> optionalPedido = repository.findById(id);
            return optionalPedido.orElseThrow(
                    () -> new RuntimeException("Pedido no encontrado")
            );
        }catch (Exception e){
            throw new RuntimeException("Error al buscar");

        }

    }

    public List<Pedido> listarPedidos(){
        return repository.findAll();
    }

    @Override
    public boolean existencia(Integer id) {
        return repository.existsById(id);
    }
}
