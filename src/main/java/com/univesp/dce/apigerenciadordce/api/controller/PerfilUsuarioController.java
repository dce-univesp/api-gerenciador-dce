package com.univesp.dce.apigerenciadordce.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.univesp.dce.apigerenciadordce.api.converter.PerfilUsuarioInputOutputConverter;
import com.univesp.dce.apigerenciadordce.api.model.input.PerfilUsuarioInput;
import com.univesp.dce.apigerenciadordce.api.model.input.SenhaInput;
import com.univesp.dce.apigerenciadordce.api.model.output.PerfilUsuarioOutput;
import com.univesp.dce.apigerenciadordce.api.model.input.PerfilUsuarioComSenhaInput;
import com.univesp.dce.apigerenciadordce.domain.model.PerfilUsuario;
import com.univesp.dce.apigerenciadordce.domain.repository.PerfilUsuarioRepository;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroPerfilUsuarioService;

@RestController
@RequestMapping(path = "/perfisUsuarios")
public class PerfilUsuarioController {
	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;
	@Autowired
	private CadastroPerfilUsuarioService cadastroPerfilUsuarioService;

	@Autowired
	private PerfilUsuarioInputOutputConverter perfilUsuarioInputOutputConverter;


	@GetMapping
	public List<PerfilUsuarioOutput> listar() {
		List<PerfilUsuario> listaPerfilUsuarios = perfilUsuarioRepository.findAll();
		return perfilUsuarioInputOutputConverter.convertDomainListToOutputList(listaPerfilUsuarios);
	}

	
	@GetMapping("/{usuarioId}")
	public PerfilUsuarioOutput buscar(@PathVariable Long usuarioId) {
		PerfilUsuario perfilUsuario = cadastroPerfilUsuarioService.buscarOuFalhar(usuarioId);		
		return perfilUsuarioInputOutputConverter.convertDomainToOutput(perfilUsuario);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PerfilUsuarioOutput adicionar(@RequestBody /*@Valid*/ PerfilUsuarioComSenhaInput usuarioInput) {
		PerfilUsuario perfilUsuario = perfilUsuarioInputOutputConverter.convertInputToDomain(usuarioInput);
		perfilUsuario = cadastroPerfilUsuarioService.salvar(perfilUsuario);
		return perfilUsuarioInputOutputConverter.convertDomainToOutput(perfilUsuario);
	}
	
	@PutMapping("/atualizar/{usuarioId}")
	public PerfilUsuarioOutput atualizar(@PathVariable Long usuarioId,
			@RequestBody /*@Valid*/ PerfilUsuarioInput perfilUsuarioInput) {
				PerfilUsuario perfilUsuarioAtual = cadastroPerfilUsuarioService.buscarOuFalhar(usuarioId);
		perfilUsuarioInputOutputConverter.copyInputToDomain(perfilUsuarioInput, perfilUsuarioAtual);
		perfilUsuarioAtual = cadastroPerfilUsuarioService.salvar(perfilUsuarioAtual);
		return perfilUsuarioInputOutputConverter.convertDomainToOutput(perfilUsuarioAtual);
	}

	@DeleteMapping("/{usuarioId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirPerfil(@PathVariable Long usuarioId) {
		cadastroPerfilUsuarioService.excluir(usuarioId);
	}

	@PutMapping("/alterarSenha/{usuarioId}/senha")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarSenha(@PathVariable Long usuarioId, @RequestBody /*@Valid*/ SenhaInput senha) {
		cadastroPerfilUsuarioService.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
	}
}
