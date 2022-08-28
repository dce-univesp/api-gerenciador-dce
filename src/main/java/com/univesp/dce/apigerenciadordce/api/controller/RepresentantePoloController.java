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

import com.univesp.dce.apigerenciadordce.api.converter.RepresentantePoloInputOutputConverter;
import com.univesp.dce.apigerenciadordce.api.model.input.RepresentantePoloInput;
import com.univesp.dce.apigerenciadordce.api.model.output.RepresentantePoloOutput;
import com.univesp.dce.apigerenciadordce.domain.model.RepresentantePolo;
import com.univesp.dce.apigerenciadordce.domain.repository.RepresentantePoloRepository;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroRepresentantePoloService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/representantePolo")
public class RepresentantePoloController {
    @Autowired
	private RepresentantePoloRepository representantePoloRepository;

	@Autowired
	private CadastroRepresentantePoloService cadastroRepresentantePoloService;

	@Autowired
	private RepresentantePoloInputOutputConverter representantePoloInputOutputConverter;

	@GetMapping("/listar")
	public List<RepresentantePoloOutput> listar() {
		List<RepresentantePolo> listarepresentantePolos = representantePoloRepository.findAll();
		return representantePoloInputOutputConverter.convertDomainListToOutputList(listarepresentantePolos);
	}

	@GetMapping("/buscar/{representantePoloId}")
	public RepresentantePoloOutput buscar(@PathVariable Long representantePoloId) {
		RepresentantePolo representantePolo = cadastroRepresentantePoloService.buscarOuFalhar(representantePoloId);
		return representantePoloInputOutputConverter.convertDomainToOutput(representantePolo);
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public RepresentantePoloOutput adicionar(@RequestBody /* @Valid */ RepresentantePoloInput representantePoloInput) {
		RepresentantePolo representantePolo = representantePoloInputOutputConverter.convertInputToDomain(representantePoloInput);
		representantePolo = cadastroRepresentantePoloService.salvar(representantePolo);
		return representantePoloInputOutputConverter.convertDomainToOutput(representantePolo);
	}

	@PutMapping("/atualizar/{representantePoloId}")
	public RepresentantePoloOutput atualizar(@PathVariable Long representantePoloId, @RequestBody /* @Valid */ RepresentantePoloInput representantePoloInput) {
		RepresentantePolo representantePoloAtual = cadastroRepresentantePoloService.buscarOuFalhar(representantePoloId);
		representantePoloInputOutputConverter.copyInputToDomain(representantePoloInput, representantePoloAtual);
		representantePoloAtual = cadastroRepresentantePoloService.salvar(representantePoloAtual);
		return representantePoloInputOutputConverter.convertDomainToOutput(representantePoloAtual);
	}

	@DeleteMapping("/excluir/{representantePoloId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirrepresentantePolo(@PathVariable Long representantePoloId) {
		cadastroRepresentantePoloService.excluir(representantePoloId);
	}
}
