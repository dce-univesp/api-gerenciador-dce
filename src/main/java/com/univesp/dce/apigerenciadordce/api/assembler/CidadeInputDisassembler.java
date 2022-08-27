package com.univesp.dce.apigerenciadordce.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.univesp.dce.apigerenciadordce.api.model.input.CidadeInput;
import com.univesp.dce.apigerenciadordce.domain.model.Cidade;
import com.univesp.dce.apigerenciadordce.domain.model.Regiao;

public class CidadeInputDisassembler {
    @Autowired
	private ModelMapper modelMapper;
	
	public Cidade toDomainObject(CidadeInput cidadeInput) {
		return modelMapper.map(cidadeInput, Cidade.class);
	}
	
	public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of 
		// com.algaworks.algafood.domain.model.Estado was altered from 1 to 2
		cidade.setRegiao(new Regiao());
		
		modelMapper.map(cidadeInput, cidade);
	}
}
