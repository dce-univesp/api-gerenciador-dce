package com.univesp.dce.apigerenciadordce.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.univesp.dce.apigerenciadordce.api.model.GrupoUsuarioModel;
import com.univesp.dce.apigerenciadordce.api.model.input.GrupoUsuarioInput;
import com.univesp.dce.apigerenciadordce.domain.model.GrupoUsuario;
import com.univesp.dce.apigerenciadordce.domain.model.PerfilUsuario;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroGrupoUsuarioService;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroPerfilUsuarioService;
import com.univesp.dce.apigerenciadordce.api.assembler.GrupoUsuarioInputDisassembler;
import com.univesp.dce.apigerenciadordce.api.assembler.GrupoUsuarioModelAssembler;

@RestController
@RequestMapping(value = "/grupoUsuario")
public class GrupoUsuarioController {

	@Autowired
	private CadastroPerfilUsuarioService cadastroPerfilUsuario;

	@Autowired
	private CadastroGrupoUsuarioService cadastroGrupoUsuarioService;

	@Autowired
	private GrupoUsuarioModelAssembler grupoUsuarioModelAssembler;
	
	@Autowired
	private GrupoUsuarioInputDisassembler grupoUsuarioInputDisassembler;
	

	@GetMapping("/listar")
	public List<GrupoUsuarioModel> listar() {
		List<GrupoUsuario> listaUsuarios = cadastroGrupoUsuarioService.listar();
		
		return grupoUsuarioModelAssembler.toCollectionModel(listaUsuarios);
	}
		
	@GetMapping("/buscar")
	public List<GrupoUsuarioModel> buscar(@PathVariable Long usuarioId) {
		PerfilUsuario perfilUsuario = cadastroPerfilUsuario.buscarOuFalhar(usuarioId);
		
		return grupoUsuarioModelAssembler.toCollectionModel(perfilUsuario.getGrupos());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GrupoUsuarioModel adicionar(@RequestBody @Valid GrupoUsuarioInput grupoUsuarioInput ){
		GrupoUsuario grupoUsuario = grupoUsuarioInputDisassembler.toDomainObject(grupoUsuarioInput);
		grupoUsuario = cadastroGrupoUsuarioService.salvar(grupoUsuario);
		return grupoUsuarioModelAssembler.toModel(grupoUsuario);
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
	public GrupoUsuarioModel atualizar(@PathVariable Long grupoId,
			@RequestBody @Valid GrupoUsuarioInput grupoInput) {
		GrupoUsuario grupoUsuarioAtual = cadastroGrupoUsuarioService.buscarOuFalhar(grupoId);
		grupoUsuarioInputDisassembler.copyToDomainObject(grupoInput, grupoUsuarioAtual);
		grupoUsuarioAtual = cadastroGrupoUsuarioService.salvar(grupoUsuarioAtual);
		return grupoUsuarioModelAssembler.toModel(grupoUsuarioAtual);
	}
	
	@DeleteMapping("/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long grupoId) {
		cadastroGrupoUsuarioService.excluir(grupoId);	
	}

}
