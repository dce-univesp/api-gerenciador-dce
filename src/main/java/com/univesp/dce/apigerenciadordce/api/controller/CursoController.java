package com.univesp.dce.apigerenciadordce.api.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.univesp.dce.apigerenciadordce.api.converter.CursoInputOutputConverter;
import com.univesp.dce.apigerenciadordce.api.model.input.CursoInput;
import com.univesp.dce.apigerenciadordce.api.model.output.CursoOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Curso;
import com.univesp.dce.apigerenciadordce.domain.repository.CursoRepository;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroCursoService;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private CadastroCursoService cadastroCursoService;
	
	@Autowired
	private CursoInputOutputConverter cursoInputOutputConverter;

	@GetMapping("/listar")
	public List<CursoOutput> listar() {
		List<Curso> listacursos = cursoRepository.findAll();
		return cursoInputOutputConverter.convertDomainListToOutputList(listacursos);
	}

	@GetMapping("/buscar/{cursoId}")
	public CursoOutput buscar(@PathVariable Long cursoId) {
		Curso curso = cadastroCursoService.buscarOuFalhar(cursoId);
		return cursoInputOutputConverter.convertDomainToOutput(curso);
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public CursoOutput adicionar(@RequestBody /* @Valid */ CursoInput cursoInput) {
		Curso curso = cursoInputOutputConverter.convertInputToDomain(cursoInput);
		curso = cadastroCursoService.salvar(curso);
		return cursoInputOutputConverter.convertDomainToOutput(curso);
	}

	@PutMapping("/atualizar/{cursoId}")
	public CursoOutput atualizar(@PathVariable Long cursoId, @RequestBody /* @Valid */ CursoInput cursoInput) {
		Curso cursoAtual = cadastroCursoService.buscarOuFalhar(cursoId);
		cursoInputOutputConverter.copyInputToDomain(cursoInput, cursoAtual);
		cursoAtual = cadastroCursoService.salvar(cursoAtual);
		return cursoInputOutputConverter.convertDomainToOutput(cursoAtual);
	}

	@DeleteMapping("/excluir/{cursoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluircurso(@PathVariable Long cursoId) {
		cadastroCursoService.excluir(cursoId);
	}
}
