package com.univesp.dce.apigerenciadordce.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.GrupoUsuarioModel;
import com.univesp.dce.apigerenciadordce.domain.model.GrupoUsuario;

@Component
public class GrupoUsuarioModelAssembler {
	@Autowired
	private ModelMapper modelMapper;
	
	public GrupoUsuarioModel toModel(GrupoUsuario grupo) {
		return modelMapper.map(grupo, GrupoUsuarioModel.class);
	}
	
	public List<GrupoUsuarioModel> toCollectionModel(Collection<GrupoUsuario> gruposUsuario) {
		return gruposUsuario.stream()
				.map(grupo -> toModel(grupo))
				.collect(Collectors.toList());
	}
}
