package com.univesp.dce.apigerenciadordce.api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.univesp.dce.apigerenciadordce.api.converter.PermissaoInputOutputConverter;

import com.univesp.dce.apigerenciadordce.domain.model.GrupoUsuario;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroGrupoUsuarioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/grupos/{grupoId}/permissoes")
public class GrupoPermissaoController {

	@Autowired
	private CadastroGrupoUsuarioService cadastroGrupoUsuarioService;

	@Autowired
	private PermissaoInputOutputConverter permissaoInputOutputConverter;

	@GetMapping
	public List<com.univesp.dce.apigerenciadordce.api.model.output.PermissaoOutput> listar(@PathVariable Long grupoId) {
		GrupoUsuario grupoUsuario = cadastroGrupoUsuarioService.buscarOuFalhar(grupoId);
		return permissaoInputOutputConverter.convertDomainListToOutputList(grupoUsuario.getPermissoes());
	}

	@DeleteMapping("/{permissaoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void desassociar(@PathVariable Long grupoId, @PathVariable Long permissaoId) {
		cadastroGrupoUsuarioService.desassociarPermissao(grupoId, permissaoId);
	}

	@PutMapping("/{permissaoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void associar(@PathVariable Long grupoId, @PathVariable Long permissaoId) {
		cadastroGrupoUsuarioService.associarPermissao(grupoId, permissaoId);
	}

}
