package com.univesp.dce.apigerenciadordce.api.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.univesp.dce.apigerenciadordce.api.converter.DiretoriaInputOutputConverter;
import com.univesp.dce.apigerenciadordce.api.model.input.DiretoriaInput;
import com.univesp.dce.apigerenciadordce.api.model.output.DiretoriaOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Diretoria;
import com.univesp.dce.apigerenciadordce.domain.repository.DiretoriaRepository;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroDiretoriaService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/diretoria")
public class DiretoriaController {
    @Autowired
	private DiretoriaRepository diretoriaRepository;

	@Autowired
	private CadastroDiretoriaService cadastroDiretoriaService;

	
	@Autowired
	private DiretoriaInputOutputConverter diretoriaInputOutputConverter;

	@GetMapping
	public List<DiretoriaOutput> listar() {
		List<Diretoria> listadiretorias = diretoriaRepository.findAll();
		return diretoriaInputOutputConverter.convertDomainListToOutputList(listadiretorias);
	}

	@GetMapping("/{diretoriaId}")
	public DiretoriaOutput buscar(@PathVariable Long diretoriaId) {
		Diretoria diretoria = cadastroDiretoriaService.buscarOuFalhar(diretoriaId);
		return diretoriaInputOutputConverter.convertDomainToOutput(diretoria);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DiretoriaOutput adicionar(@RequestBody /* @Valid */ DiretoriaInput diretoriaInput) {
		Diretoria diretoria = diretoriaInputOutputConverter.convertInputToDomain(diretoriaInput);
		diretoria = cadastroDiretoriaService.salvar(diretoria);
		return diretoriaInputOutputConverter.convertDomainToOutput(diretoria);
	}

	@PutMapping("/{diretoriaId}")
	public DiretoriaOutput atualizar(@PathVariable Long diretoriaId, @RequestBody /* @Valid */ DiretoriaInput diretoriaInput) {
		Diretoria diretoriaAtual = cadastroDiretoriaService.buscarOuFalhar(diretoriaId);
		diretoriaInputOutputConverter.copyInputToDomain(diretoriaInput, diretoriaAtual);
		diretoriaAtual = cadastroDiretoriaService.salvar(diretoriaAtual);
		return diretoriaInputOutputConverter.convertDomainToOutput(diretoriaAtual);
	}

	@DeleteMapping("/{diretoriaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirdiretoria(@PathVariable Long diretoriaId) {
		cadastroDiretoriaService.excluir(diretoriaId);
	}
}
