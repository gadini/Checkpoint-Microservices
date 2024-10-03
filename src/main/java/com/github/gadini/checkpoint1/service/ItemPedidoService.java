package com.github.gadini.checkpoint1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gadini.checkpoint1.model.ItemPedido;
import com.github.gadini.checkpoint1.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public java.util.List<ItemPedido> list(){
        return itemPedidoRepository.findAll();
    }

    public ItemPedido save(ItemPedido ItemPedido){
        return itemPedidoRepository.save(ItemPedido);
    }

    public boolean existsById(Long id) {
        return itemPedidoRepository.existsById(id);
    }

    public void delete(Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public Optional<ItemPedido> findById(Long id) {
        return itemPedidoRepository.findById(id);
    }
	
}
