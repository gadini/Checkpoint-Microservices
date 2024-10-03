package com.github.gadini.checkpoint1.dtos.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.github.gadini.checkpoint1.model.Pedido;

public class PedidoRequestCreateDto {

	private LocalDate data_pedido;
	private String forma_pagamento;
	private Long id_cliente;
	private String status;
	private BigDecimal valor_total;
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	public Pedido toModel() {
        return modelMapper.map(this, Pedido.class);
    }
	
	public LocalDate getData_pedido() {
		return data_pedido;
	}
	public void setData_pedido(LocalDate data_pedido) {
		this.data_pedido = data_pedido;
	}
	public String getForma_pagamento() {
		return forma_pagamento;
	}
	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getValor_total() {
		return valor_total;
	}
	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}
	
}
