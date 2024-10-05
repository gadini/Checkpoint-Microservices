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

import com.github.gadini.checkpoint1.dtos.pedido.PedidoRequestCreateDto;
import com.github.gadini.checkpoint1.dtos.pedido.PedidoRequestUpdateDto;
import com.github.gadini.checkpoint1.dtos.pedido.PedidoResponseDto;
import com.github.gadini.checkpoint1.mapper.PedidoMapper;
import com.github.gadini.checkpoint1.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoMapper pedidoMapper;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> list(){

        List<PedidoResponseDto> dtos = pedidoService.list()
        .stream()
        .map(e -> pedidoMapper.toDto(e))
        .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> create(@RequestBody PedidoRequestCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(pedidoMapper.toDto(pedidoService.save(pedidoMapper.toModel(dto))));
    }

    @PutMapping("{id}")
    public ResponseEntity<PedidoResponseDto> update(@PathVariable Long id, @RequestBody PedidoRequestUpdateDto dto){
        
        if(! pedidoService.existsById(id)){
           throw new RuntimeException("Id inexistente");
        }

        return ResponseEntity.ok().body(pedidoMapper.toDto(pedidoService.save(pedidoMapper.toModel(id, dto))));
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        if(! pedidoService.existsById(id)){
           throw new RuntimeException("Id inexistente");
        }

        pedidoService.delete(id);

    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoResponseDto> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(pedidoService.findById(id).map(e -> pedidoMapper.toDto(e))
        .orElseThrow(() -> new RuntimeException("Produto inexistente")));
 
    }
	
}
