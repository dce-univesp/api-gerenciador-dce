package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.CursoInput;
import com.univesp.dce.apigerenciadordce.api.model.output.CursoOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Curso;
import com.univesp.dce.apigerenciadordce.domain.model.Eixo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Component
public class CursoInputOutputConverter {
	@Autowired
	private ModelMapper modelMapper;

	public Curso convertInputToDomain(CursoInput cidadeInput) {
		return modelMapper.map(cidadeInput, Curso.class);
	}

	public void copyInputToDomain(CursoInput cursoInput, Curso curso) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of
		// com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2
		curso.setEixo(new Eixo());

		modelMapper.map(cursoInput, curso);
	}

	public CursoOutput convertDomainToOutput(Curso curso) {
		return modelMapper.map(curso, CursoOutput.class);
	}

	public List<CursoOutput> convertDomainListToOutputList(Collection<Curso> listaCursos) {
		return listaCursos.stream()
				// .map(curso -> convertDomainToOutput(curso))
				.map(this::convertDomainToOutput)
				.collect(Collectors.toList());
	}
}
