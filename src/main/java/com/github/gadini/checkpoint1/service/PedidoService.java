package com.github.gadini.checkpoint1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gadini.checkpoint1.model.Pedido;
import com.github.gadini.checkpoint1.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository PedidoRepository;
	
	public java.util.List<Pedido> list(){
        return PedidoRepository.findAll();
    }

    public Pedido save(Pedido Pedido){
        return PedidoRepository.save(Pedido);
    }

    public boolean existsById(Long id) {
        return PedidoRepository.existsById(id);
    }

    public void delete(Long id) {
        PedidoRepository.deleteById(id);
    }

    public Optional<Pedido> findById(Long id) {
        return PedidoRepository.findById(id);
    }
	
}
