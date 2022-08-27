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

import com.univesp.dce.apigerenciadordce.api.assembler.PerfilUsuarioInputDisassembler;
import com.univesp.dce.apigerenciadordce.api.assembler.PerfilUsuarioModelAssembler;
import com.univesp.dce.apigerenciadordce.api.model.input.PerfilUsuarioInput;
import com.univesp.dce.apigerenciadordce.api.model.input.SenhaInput;
import com.univesp.dce.apigerenciadordce.api.model.PerfilUsuarioModel;
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
	private PerfilUsuarioModelAssembler usuarioModelAssembler;

	@Autowired
	private PerfilUsuarioInputDisassembler perfilUsuarioInputDisassembler;

	@GetMapping("/listarPerfis")
	public List<PerfilUsuarioModel> listar() {
		List<PerfilUsuario> listaPerfilUsuarios = perfilUsuarioRepository.findAll();
		return usuarioModelAssembler.toCollectionModel(listaPerfilUsuarios);
	}
	
	@GetMapping("/buscarPerfil/{usuarioId}")
	public PerfilUsuarioModel buscar(@PathVariable Long usuarioId) {
		PerfilUsuario perfilUsuario = cadastroPerfilUsuarioService.buscarOuFalhar(usuarioId);		
		return usuarioModelAssembler.toModel(perfilUsuario);
	}
	
	@PostMapping("/cadastrarPerfil")
	@ResponseStatus(HttpStatus.CREATED)
	public PerfilUsuarioModel adicionar(@RequestBody /*@Valid*/ PerfilUsuarioComSenhaInput usuarioInput) {
		PerfilUsuario perfilUsuario = perfilUsuarioInputDisassembler.toDomainObject(usuarioInput);
		perfilUsuario = cadastroPerfilUsuarioService.salvar(perfilUsuario);
		return usuarioModelAssembler.toModel(perfilUsuario);
	}
	
	@PutMapping("/atualizarPerfil/{usuarioId}")
	public PerfilUsuarioModel atualizar(@PathVariable Long usuarioId,
			@RequestBody /*@Valid*/ PerfilUsuarioInput perfilUsuarioInput) {
				PerfilUsuario usuarioAtual = cadastroPerfilUsuarioService.buscarOuFalhar(usuarioId);
		perfilUsuarioInputDisassembler.copyToDomainObject(perfilUsuarioInput, usuarioAtual);
		usuarioAtual = cadastroPerfilUsuarioService.salvar(usuarioAtual);
		return usuarioModelAssembler.toModel(usuarioAtual);
	}
	
	@DeleteMapping("/excluirPerfil/{usuarioId}")
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
