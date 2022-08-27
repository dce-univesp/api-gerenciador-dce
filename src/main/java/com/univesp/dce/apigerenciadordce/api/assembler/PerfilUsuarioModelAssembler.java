package com.univesp.dce.apigerenciadordce.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.PerfilUsuarioModel;
import com.univesp.dce.apigerenciadordce.domain.model.PerfilUsuario;


@Component
public class PerfilUsuarioModelAssembler {
    
    @Autowired	
    private ModelMapper modelMapper;

	public PerfilUsuarioModel toModel(PerfilUsuario usuario) {
		return modelMapper.map(usuario, PerfilUsuarioModel.class);
	}
	
	public List<PerfilUsuarioModel> toCollectionModel(Collection<PerfilUsuario> usuarios) {
		return usuarios.stream()
				.map(usuario -> toModel(usuario))
				.collect(Collectors.toList());
	}
	
}
