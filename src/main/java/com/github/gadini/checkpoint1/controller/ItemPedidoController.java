package com.github.gadini.checkpoint1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.github.gadini.checkpoint1.dtos.itempedido.ItemPedidoRequestCreateDto;
import com.github.gadini.checkpoint1.dtos.itempedido.ItemPedidoRequestUpdateDto;
import com.github.gadini.checkpoint1.dtos.itempedido.ItemPedidoResponseDto;
import com.github.gadini.checkpoint1.service.ItemPedidoService;

@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

	@Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> list(){

        List<ItemPedidoResponseDto> dtos = itemPedidoService.list()
        .stream()
        .map(e -> new ItemPedidoResponseDto().toDto(e))
        .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDto> create(@RequestBody ItemPedidoRequestCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ItemPedidoResponseDto().toDto(itemPedidoService.save(dto.toModel())));
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> update(@PathVariable Long id, @RequestBody ItemPedidoRequestUpdateDto dto){
        
        if(! itemPedidoService.existsById(id)){
           throw new RuntimeException("Id inexistente");
        }

        return ResponseEntity.ok().body(new ItemPedidoResponseDto().toDto(itemPedidoService.save(dto.toModel(id))));
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        if(! itemPedidoService.existsById(id)){
           throw new RuntimeException("Id inexistente");
        }

        itemPedidoService.delete(id);

    }

    @GetMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(itemPedidoService.findById(id).map(e -> new ItemPedidoResponseDto().toDto(e))
        .orElseThrow(() -> new RuntimeException("Produto inexistente")));
 
    }
	
}
