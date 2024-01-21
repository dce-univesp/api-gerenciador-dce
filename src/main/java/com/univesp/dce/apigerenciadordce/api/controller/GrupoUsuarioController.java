package com.univesp.dce.apigerenciadordce.api.controller;

import java.util.List;

import javax.validation.Valid;

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


import com.univesp.dce.apigerenciadordce.api.model.input.GrupoUsuarioInput;
import com.univesp.dce.apigerenciadordce.api.model.output.GrupoUsuarioOutput;
import com.univesp.dce.apigerenciadordce.domain.model.GrupoUsuario;
import com.univesp.dce.apigerenciadordce.domain.model.PerfilUsuario;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroGrupoUsuarioService;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroPerfilUsuarioService;
import com.univesp.dce.apigerenciadordce.api.converter.GrupoUsuarioInputOutputConverter;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/grupoUsuario")
public class GrupoUsuarioController {

	@Autowired
	private CadastroPerfilUsuarioService cadastroPerfilUsuario;

	@Autowired
	private CadastroGrupoUsuarioService cadastroGrupoUsuarioService;

	@Autowired
	private GrupoUsuarioInputOutputConverter grupoUsuarioInputOutputConverter;
	

	@GetMapping
	public List<GrupoUsuarioOutput> listar() {
		List<GrupoUsuario> listaUsuarios = cadastroGrupoUsuarioService.listar();
		return grupoUsuarioInputOutputConverter.convertDomainListToOutputList(listaUsuarios);
	}

 	@GetMapping("/{usuarioId}")
	public List<GrupoUsuarioOutput> buscar(@PathVariable Long usuarioId) {
		PerfilUsuario perfilUsuario = cadastroPerfilUsuario.buscarOuFalhar(usuarioId);
		return grupoUsuarioInputOutputConverter.convertDomainListToOutputList(perfilUsuario.getGrupos());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GrupoUsuarioOutput adicionar(@RequestBody @Valid GrupoUsuarioInput grupoUsuarioInput ){
		GrupoUsuario grupoUsuario = grupoUsuarioInputOutputConverter.convertInputToDomain(grupoUsuarioInput);
		grupoUsuario = cadastroGrupoUsuarioService.salvar(grupoUsuario);
		return grupoUsuarioInputOutputConverter.convertDomainToOutput(grupoUsuario);
	}

	@DeleteMapping("/desassociar/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void desassociar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		cadastroPerfilUsuario.desassociarGrupo(usuarioId, grupoId);
	}

	
	@PutMapping("/associar/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void associar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		cadastroPerfilUsuario.associarGrupo(usuarioId, grupoId);
	}

	
	@PutMapping("/{grupoId}")
	public GrupoUsuarioOutput atualizar(@PathVariable Long grupoId,
			@RequestBody @Valid GrupoUsuarioInput grupoUsuarioInput) {
		GrupoUsuario grupoUsuarioAtual = cadastroGrupoUsuarioService.buscarOuFalhar(grupoId);
		grupoUsuarioInputOutputConverter.copyInputToDomain(grupoUsuarioInput, grupoUsuarioAtual);
		grupoUsuarioAtual = cadastroGrupoUsuarioService.salvar(grupoUsuarioAtual);
		return grupoUsuarioInputOutputConverter.convertDomainToOutput(grupoUsuarioAtual);
	}

	@DeleteMapping("/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long grupoId) {
		cadastroGrupoUsuarioService.excluir(grupoId);	
	}
}
