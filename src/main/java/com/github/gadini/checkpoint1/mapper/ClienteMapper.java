package com.github.gadini.checkpoint1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.gadini.checkpoint1.dtos.ClienteRequestCreateDto;
import com.github.gadini.checkpoint1.dtos.ClienteRequestUpdateDto;
import com.github.gadini.checkpoint1.dtos.ClienteResponseDto;
import com.github.gadini.checkpoint1.model.Cliente;

@Component
public class ClienteMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteResponseDto toDto(Cliente cliente){
    	ClienteResponseDto result = modelMapper.map(cliente, ClienteResponseDto.class);
        return result;
    }

    public Cliente toModel(ClienteRequestCreateDto dto) {
        return modelMapper.map(dto, Cliente.class);
    }

    public Cliente toModel(Long id, ClienteRequestUpdateDto dto) {
		Cliente result =  modelMapper.map(dto, Cliente.class);
        result.setId(id);
        return result;
    }

}
