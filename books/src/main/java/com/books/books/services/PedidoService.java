package com.books.books.services;

import com.books.books.models.PedidoModel;
import com.books.books.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoModel> findAll(){
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> buscarId(Long id){
        return pedidoRepository.findById(id);
    }

    public PedidoModel criarPedido(PedidoModel model){
        return pedidoRepository.save(model);
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }

    public PedidoModel atualizarStatusPedido(PedidoModel model, Long id){
        PedidoModel atual = pedidoRepository.findById(id).get();

        atual.setStatus(model.getStatus());

        return pedidoRepository.save(atual);
    }
}
