package com.github.gadini.checkpoint1.dtos.produto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import com.github.gadini.checkpoint1.model.Produto;

public class ProdutoResquestCreateDto {

	private String nome;
	private BigDecimal valor;
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	public Produto toModel() {
        return modelMapper.map(this, Produto.class);
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
