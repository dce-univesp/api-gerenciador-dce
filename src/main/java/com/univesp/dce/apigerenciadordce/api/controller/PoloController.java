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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.univesp.dce.apigerenciadordce.api.converter.PoloInputOutputConverter;
import com.univesp.dce.apigerenciadordce.api.model.input.PoloInput;
import com.univesp.dce.apigerenciadordce.api.model.output.PoloOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Polo;
import com.univesp.dce.apigerenciadordce.domain.repository.PoloRepository;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroPoloService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/polo")
public class PoloController {
	@Autowired
	private PoloRepository poloRepository;

	@Autowired
	private CadastroPoloService cadastroPoloService;

	@Autowired
	private PoloInputOutputConverter poloInputOutputConverter;

	@GetMapping
	public List<PoloOutput> listar() {
		List<Polo> listapolos = poloRepository.findAll();
		return poloInputOutputConverter.convertDomainListToOutputList(listapolos);
	}

	@GetMapping("/{poloId}")
	public PoloOutput buscar(@PathVariable Long poloId) {
		Polo polo = cadastroPoloService.buscarOuFalhar(poloId);
		return poloInputOutputConverter.convertDomainToOutput(polo);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PoloOutput adicionar(@RequestBody /* @Valid */ PoloInput poloInput) {
		Polo polo = poloInputOutputConverter.convertInputToDomain(poloInput);
		polo = cadastroPoloService.salvar(polo);
		return poloInputOutputConverter.convertDomainToOutput(polo);
	}

	@PutMapping("/{poloId}")
	public PoloOutput atualizar(@PathVariable Long poloId, @RequestBody /* @Valid */ PoloInput poloInput) {
		Polo poloAtual = cadastroPoloService.buscarOuFalhar(poloId);
		poloInputOutputConverter.copyInputToDomain(poloInput, poloAtual);
		poloAtual = cadastroPoloService.salvar(poloAtual);
		return poloInputOutputConverter.convertDomainToOutput(poloAtual);
	}

	@DeleteMapping("/{poloId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirpolo(@PathVariable Long poloId) {
		cadastroPoloService.excluir(poloId);
	}
}
