package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.PermissaoInput;
import com.univesp.dce.apigerenciadordce.api.model.output.PermissaoOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Permissao;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissaoInputOutputConverter {
	@Autowired
	private ModelMapper modelMapper;

	public Permissao convertInputToDomain(PermissaoInput cidadeInput) {
		return modelMapper.map(cidadeInput, Permissao.class);
	}

	public void copyInputToDomain(PermissaoInput permissaoInput, Permissao permissao) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of
		// com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2

		modelMapper.map(permissaoInput, permissao);
	}

	public PermissaoOutput convertDomainToOutput(Permissao permissao) {
		return modelMapper.map(permissao, PermissaoOutput.class);
	}

	public List<PermissaoOutput> convertDomainListToOutputList(Collection<Permissao> listaPermissaos) {
		return listaPermissaos.stream()
				// .map(permissao -> convertDomainToOutput(permissao))
				.map(this::convertDomainToOutput)
				.collect(Collectors.toList());
	}
}
