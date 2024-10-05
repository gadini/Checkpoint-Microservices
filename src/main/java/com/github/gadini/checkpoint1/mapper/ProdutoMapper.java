package com.github.gadini.checkpoint1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.gadini.checkpoint1.dtos.produto.ProdutoRequestCreateDto;
import com.github.gadini.checkpoint1.dtos.produto.ProdutoRequestUpdateDto;
import com.github.gadini.checkpoint1.dtos.produto.ProdutoResponseDto;
import com.github.gadini.checkpoint1.model.Produto;

@Component
public class ProdutoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoResponseDto toDto(Produto produto){
    	ProdutoResponseDto result = modelMapper.map(produto, ProdutoResponseDto.class);
        return result;
    }

    public Produto toModel(ProdutoRequestCreateDto dto) {
        return modelMapper.map(dto, Produto.class);
    }

    public Produto toModel(Long id, ProdutoRequestUpdateDto dto) {
		Produto result =  modelMapper.map(dto, Produto.class);
        result.setId(id);
        return result;
    }

}
