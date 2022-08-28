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

import com.univesp.dce.apigerenciadordce.api.converter.CidadeInputOutputConverter;
import com.univesp.dce.apigerenciadordce.api.model.input.CidadeInput;
import com.univesp.dce.apigerenciadordce.api.model.output.CidadeOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Cidade;
import com.univesp.dce.apigerenciadordce.domain.repository.CidadeRepository;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroCidadeService;


@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidadeService;

	@Autowired
	private CidadeInputOutputConverter cidadeInputOutputConverter;

	@GetMapping("/listar")
	public List<CidadeOutput> listar() {
		List<Cidade> listaCidades = cidadeRepository.findAll();
		return cidadeInputOutputConverter.convertDomainListToOutputList(listaCidades);
	}

	@GetMapping("/buscar/{cidadeId}")
	public CidadeOutput buscar(@PathVariable Long cidadeId) {
		Cidade cidade = cadastroCidadeService.buscarOuFalhar(cidadeId);
		return cidadeInputOutputConverter.convertDomainToOutput(cidade);
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeOutput adicionar(@RequestBody /* @Valid */ CidadeInput cidadeInput) {
		Cidade cidade = cidadeInputOutputConverter.convertInputToDomain(cidadeInput);
		cidade = cadastroCidadeService.salvar(cidade);
		return cidadeInputOutputConverter.convertDomainToOutput(cidade);
	}

	@PutMapping("/atualizar/{cidadeId}")
	public CidadeOutput atualizar(@PathVariable Long cidadeId, @RequestBody /* @Valid */ CidadeInput cidadeInput) {
		Cidade cidadeAtual = cadastroCidadeService.buscarOuFalhar(cidadeId);
		cidadeInputOutputConverter.copyInputToDomain(cidadeInput, cidadeAtual);
		cidadeAtual = cadastroCidadeService.salvar(cidadeAtual);
		return cidadeInputOutputConverter.convertDomainToOutput(cidadeAtual);
	}

	@DeleteMapping("/excluir/{cidadeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirCidade(@PathVariable Long cidadeId) {
		cadastroCidadeService.excluir(cidadeId);
	}
}
