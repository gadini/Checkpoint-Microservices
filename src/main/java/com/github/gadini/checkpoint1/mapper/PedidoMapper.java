package com.github.gadini.checkpoint1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.gadini.checkpoint1.dtos.pedido.PedidoRequestCreateDto;
import com.github.gadini.checkpoint1.dtos.pedido.PedidoRequestUpdateDto;
import com.github.gadini.checkpoint1.dtos.pedido.PedidoResponseDto;
import com.github.gadini.checkpoint1.model.Pedido;

@Component
public class PedidoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoResponseDto toDto(Pedido pedido){
    	PedidoResponseDto result = modelMapper.map(pedido, PedidoResponseDto.class);
        return result;
    }

    public Pedido toModel(PedidoRequestCreateDto dto) {
        return modelMapper.map(dto, Pedido.class);
    }

    public Pedido toModel(Long id, PedidoRequestUpdateDto dto) {
		Pedido result =  modelMapper.map(dto, Pedido.class);
        result.setId(id);
        return result;
    }

}
