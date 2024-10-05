package com.github.gadini.checkpoint1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gadini.checkpoint1.dtos.produto.ProdutoRequestCreateDto;
import com.github.gadini.checkpoint1.dtos.produto.ProdutoRequestUpdateDto;
import com.github.gadini.checkpoint1.dtos.produto.ProdutoResponseDto;
import com.github.gadini.checkpoint1.mapper.ProdutoMapper;
import com.github.gadini.checkpoint1.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

	private final ProdutoService produtoService;
	
    private final ProdutoMapper produtoMapper;

	@GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> list(){

        List<ProdutoResponseDto> dtos = produtoService.list()
        .stream()
        .map(e -> produtoMapper.toDto(e))
        .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> create(@RequestBody ProdutoRequestCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(produtoMapper.toDto(produtoService.save(produtoMapper.toModel(dto))));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponseDto> update(@PathVariable Long id, @RequestBody ProdutoRequestUpdateDto dto){
        
        if(! produtoService.existsById(id)){
           throw new RuntimeException("Id inexistente");
        }

        return ResponseEntity.ok().body(produtoMapper.toDto(produtoService.save(produtoMapper.toModel(id,dto))));
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        if(! produtoService.existsById(id)){
           throw new RuntimeException("Id inexistente");
        }

        produtoService.delete(id);

    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponseDto> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(produtoService.findById(id).map(e -> produtoMapper.toDto(e))
        .orElseThrow(() -> new RuntimeException("Produto inexistente")));
 
    }
	
}
