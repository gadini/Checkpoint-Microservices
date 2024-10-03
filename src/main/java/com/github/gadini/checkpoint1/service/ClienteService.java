package com.github.gadini.checkpoint1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gadini.checkpoint1.model.Cliente;
import com.github.gadini.checkpoint1.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public java.util.List<Cliente> list(){
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente Cliente){
        return clienteRepository.save(Cliente);
    }

    public boolean existsById(Long id) {
        return clienteRepository.existsById(id);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
}
