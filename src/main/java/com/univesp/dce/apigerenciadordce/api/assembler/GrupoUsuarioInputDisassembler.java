package com.univesp.dce.apigerenciadordce.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.GrupoUsuarioInput;
import com.univesp.dce.apigerenciadordce.domain.model.GrupoUsuario;


@Component 
public class GrupoUsuarioInputDisassembler {
    @Autowired
	private ModelMapper modelMapper;
	
	public GrupoUsuario toDomainObject(GrupoUsuarioInput grupoUsuarioInput) {
		return modelMapper.map( grupoUsuarioInput, GrupoUsuario.class);
	}
	
	public void copyToDomainObject(GrupoUsuarioInput grupoUsuarioInput, GrupoUsuario grupoUsuario) {
		modelMapper.map(grupoUsuarioInput, grupoUsuario);
	}
	
}
