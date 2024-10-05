package com.github.gadini.checkpoint1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.gadini.checkpoint1.dtos.itempedido.ItemPedidoRequestCreateDto;
import com.github.gadini.checkpoint1.dtos.itempedido.ItemPedidoRequestUpdateDto;
import com.github.gadini.checkpoint1.dtos.itempedido.ProdutoResponseDto;
import com.github.gadini.checkpoint1.model.ItemPedido;

@Component
public class ItemPedidoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoResponseDto toDto(ItemPedido itemPedido){
    	ProdutoResponseDto result = modelMapper.map(itemPedido, ProdutoResponseDto.class);
        return result;
    }

    public ItemPedido toModel(ItemPedidoRequestCreateDto dto) {
        return modelMapper.map(dto, ItemPedido.class);
    }

    public ItemPedido toModel(Long id, ItemPedidoRequestUpdateDto dto) {
		ItemPedido result =  modelMapper.map(dto, ItemPedido.class);
        result.setId(id);
        return result;
    }

}
