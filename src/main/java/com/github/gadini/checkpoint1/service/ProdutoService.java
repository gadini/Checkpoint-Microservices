package com.github.gadini.checkpoint1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gadini.checkpoint1.model.Produto;
import com.github.gadini.checkpoint1.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository ProdutoRepository;
	
	public java.util.List<Produto> list(){
        return ProdutoRepository.findAll();
    }

    public Produto save(Produto Produto){
        return ProdutoRepository.save(Produto);
    }

    public boolean existsById(Long id) {
        return ProdutoRepository.existsById(id);
    }

    public void delete(Long id) {
        ProdutoRepository.deleteById(id);
    }

    public Optional<Produto> findById(Long id) {
        return ProdutoRepository.findById(id);
    }
	
}
