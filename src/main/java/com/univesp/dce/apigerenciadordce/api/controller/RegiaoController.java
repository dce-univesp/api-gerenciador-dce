package com.univesp.dce.apigerenciadordce.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.univesp.dce.apigerenciadordce.api.converter.RegiaoInputOutputConverter;
import com.univesp.dce.apigerenciadordce.api.model.input.RegiaoInput;
import com.univesp.dce.apigerenciadordce.api.model.output.RegiaoOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Regiao;
import com.univesp.dce.apigerenciadordce.domain.repository.RegiaoRepository;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroRegiaoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/regiao")
public class RegiaoController {
    @Autowired
	private RegiaoRepository regiaoRepository;

	@Autowired
	private CadastroRegiaoService cadastroRegiaoService;

	@Autowired
	private RegiaoInputOutputConverter regiaoInputOutputConverter;

	@GetMapping
	public List<RegiaoOutput> listar() {
		List<Regiao> listaregioes = regiaoRepository.findAll();
		return regiaoInputOutputConverter.convertDomainListToOutputList(listaregioes);
	}

	@GetMapping("/{regiaoId}")
	public RegiaoOutput buscar(@PathVariable Long regiaoId) {
		Regiao regiao = cadastroRegiaoService.buscarOuFalhar(regiaoId);
		return regiaoInputOutputConverter.convertDomainToOutput(regiao);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RegiaoOutput adicionar(@RequestBody /* @Valid */ RegiaoInput regiaoInput) {
		Regiao regiao = regiaoInputOutputConverter.convertInputToDomain(regiaoInput);
		regiao = cadastroRegiaoService.salvar(regiao);
		return regiaoInputOutputConverter.convertDomainToOutput(regiao);
	}

	@PutMapping("/{regiaoId}")
	public RegiaoOutput atualizar(@PathVariable Long regiaoId, @RequestBody /* @Valid */ RegiaoInput regiaoInput) {
		Regiao regiaoAtual = cadastroRegiaoService.buscarOuFalhar(regiaoId);
		regiaoInputOutputConverter.copyInputToDomain(regiaoInput, regiaoAtual);
		regiaoAtual = cadastroRegiaoService.salvar(regiaoAtual);
		return regiaoInputOutputConverter.convertDomainToOutput(regiaoAtual);
	}

	@DeleteMapping("/{regiaoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirregiao(@PathVariable Long regiaoId) {
		cadastroRegiaoService.excluir(regiaoId);
	}
}
