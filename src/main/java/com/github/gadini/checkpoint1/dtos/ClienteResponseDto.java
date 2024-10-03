package com.github.gadini.checkpoint1.dtos;

import org.modelmapper.ModelMapper;

import com.github.gadini.checkpoint1.model.Cliente;

public class ClienteResponseDto {

	private Long id;
	private String bairro;
	private String cep;
	private String complemento;
	private String logradouro;
	private String municipio;
	private String nome;
	private String numero;
	private String uf;
	
	private static final ModelMapper modelMapper = new ModelMapper();

    public ClienteResponseDto toDto(Cliente cliente){
        ClienteResponseDto result = modelMapper.map(cliente, ClienteResponseDto.class);
        return result;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
