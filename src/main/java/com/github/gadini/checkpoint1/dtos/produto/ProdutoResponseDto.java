package com.github.gadini.checkpoint1.dtos.produto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import com.github.gadini.checkpoint1.model.Produto;

public class ProdutoResponseDto {

	private Long id;
	private String nome;
	private BigDecimal valor;
	
	private static final ModelMapper modelMapper = new ModelMapper();

    public ProdutoResponseDto toDto(Produto Produto){
        ProdutoResponseDto result = modelMapper.map(Produto, ProdutoResponseDto.class);
        return result;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
