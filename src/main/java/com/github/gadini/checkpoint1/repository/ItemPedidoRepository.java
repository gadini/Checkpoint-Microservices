package com.github.gadini.checkpoint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.gadini.checkpoint1.model.ItemPedido;
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}
