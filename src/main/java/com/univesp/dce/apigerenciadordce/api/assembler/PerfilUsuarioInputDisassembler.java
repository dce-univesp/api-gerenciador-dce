package com.univesp.dce.apigerenciadordce.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.PerfilUsuarioInput;
import com.univesp.dce.apigerenciadordce.domain.model.PerfilUsuario;

@Component
public class PerfilUsuarioInputDisassembler {
    
    @Autowired
	private ModelMapper modelMapper;
	
    public PerfilUsuario toDomainObject(PerfilUsuarioInput usuarioInput) {
		return modelMapper.map(usuarioInput, PerfilUsuario.class);
	}
	
	public void copyToDomainObject(PerfilUsuarioInput usuarioPerfilInput, PerfilUsuario perfilUsuario) {
		modelMapper.map(usuarioPerfilInput, perfilUsuario);
	}
}
