package com.univesp.dce.apigerenciadordce.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.CidadeModel;
import com.univesp.dce.apigerenciadordce.domain.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class CidadeModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public CidadeModel toModel(Cidade cidade) {
		return modelMapper.map(cidade, CidadeModel.class);
	}
	
	public List<CidadeModel> toCollectionModel(List<Cidade> cidades) {
		return cidades.stream()
			//	.map(cidade -> toModel(cidade))
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
}
