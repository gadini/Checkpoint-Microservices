package com.github.gadini.checkpoint1.dtos.itempedido;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import com.github.gadini.checkpoint1.model.ItemPedido;

public class ItemPedidoRequestCreateDto {

	private Long id_pedido;
	private Long id_cliente;
	private Long quantidade;
	private BigDecimal valor_total;
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	public ItemPedido toModel() {
        return modelMapper.map(this, ItemPedido.class);
    }
	
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor_total() {
		return valor_total;
	}
	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}
	
}
