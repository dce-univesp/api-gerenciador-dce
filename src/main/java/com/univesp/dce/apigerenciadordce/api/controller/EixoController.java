package com.univesp.dce.apigerenciadordce.api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.univesp.dce.apigerenciadordce.api.converter.EixoInputOutputConverter;
import com.univesp.dce.apigerenciadordce.api.model.input.EixoInput;
import com.univesp.dce.apigerenciadordce.api.model.output.EixoOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Eixo;
import com.univesp.dce.apigerenciadordce.domain.repository.EixoRepository;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroEixoService;

@RestController
@RequestMapping(value = "/eixo")
public class EixoController {
	@Autowired
	private EixoRepository eixoRepository;

	@Autowired
	private CadastroEixoService cadastroEixoService;

	@Autowired
	private EixoInputOutputConverter eixoInputOutputConverter;

	@GetMapping("/listar")
	public List<EixoOutput> listar() {
		List<Eixo> listaeixos = eixoRepository.findAll();
		return eixoInputOutputConverter.convertDomainListToOutputList(listaeixos);
	}

	@GetMapping("/buscar/{eixoId}")
	public EixoOutput buscar(@PathVariable Long eixoId) {
		Eixo eixo = cadastroEixoService.buscarOuFalhar(eixoId);
		return eixoInputOutputConverter.convertDomainToOutput(eixo);
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public EixoOutput adicionar(@RequestBody /* @Valid */ EixoInput eixoInput) {
		Eixo eixo = eixoInputOutputConverter.convertInputToDomain(eixoInput);
		eixo = cadastroEixoService.salvar(eixo);
		return eixoInputOutputConverter.convertDomainToOutput(eixo);
	}

	@PutMapping("/atualizar/{eixoId}")
	public EixoOutput atualizar(@PathVariable Long eixoId, @RequestBody /* @Valid */ EixoInput eixoInput) {
		Eixo eixoAtual = cadastroEixoService.buscarOuFalhar(eixoId);
		eixoInputOutputConverter.copyInputToDomain(eixoInput, eixoAtual);
		eixoAtual = cadastroEixoService.salvar(eixoAtual);
		return eixoInputOutputConverter.convertDomainToOutput(eixoAtual);
	}

	@DeleteMapping("/excluir/{eixoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluireixo(@PathVariable Long eixoId) {
		cadastroEixoService.excluir(eixoId);
	}
}
