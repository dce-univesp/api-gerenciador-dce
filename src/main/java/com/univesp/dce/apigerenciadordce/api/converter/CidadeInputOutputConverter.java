package com.univesp.dce.apigerenciadordce.api.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.univesp.dce.apigerenciadordce.api.model.input.CidadeInput;
import com.univesp.dce.apigerenciadordce.api.model.output.CidadeOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Cidade;
import com.univesp.dce.apigerenciadordce.domain.model.Regiao;

@Component
public class CidadeInputOutputConverter {

	@Autowired
	private ModelMapper modelMapper;

	public Cidade convertInputToDomain(CidadeInput cidadeInput) {
		return modelMapper.map(cidadeInput, Cidade.class);
	}

	public void copyInputToDomain(CidadeInput cidadeInput, Cidade cidade) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of
		// com.algaworks.algafood.domain.model.Estado was altered from 1 to 2
		cidade.setRegiao(new Regiao());

		modelMapper.map(cidadeInput, cidade);
	}

	public CidadeOutput convertDomainToOutput(Cidade cidade) {
		return modelMapper.map(cidade, CidadeOutput.class);
	}

	public List<CidadeOutput> convertDomainListToOutputList(Collection<Cidade> cidades) {
		return cidades.stream()
				// .map(cidade -> toModel(cidade))
				.map(this::convertDomainToOutput)
				.collect(Collectors.toList());
	}

}
