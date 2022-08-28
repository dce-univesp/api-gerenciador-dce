package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.exception.UsuarioNaoEncontradoException;
import com.univesp.dce.apigerenciadordce.domain.model.GrupoUsuario;
import com.univesp.dce.apigerenciadordce.domain.model.PerfilUsuario;
import com.univesp.dce.apigerenciadordce.domain.repository.PerfilUsuarioRepository;

@Service
public class CadastroPerfilUsuarioService {

	@Autowired
	private PerfilUsuarioRepository perfilRepository;

	@Autowired
	private CadastroGrupoUsuarioService cadastroGrupoUsuarioService;

	@Transactional
	public PerfilUsuario salvar(PerfilUsuario perfil) {
		// perfilRepository.detach(perfil);

		Optional<PerfilUsuario> perfilExistente = perfilRepository.findByEmailAcademico(perfil.getEmailAcademico());

		if (perfilExistente.isPresent() && !perfilExistente.get().equals(perfil)) {
			throw new NegocioException(
					String.format("Já existe um usuário cadastrado com o e-mail %s", perfil.getEmailAcademico()));
		}

		return perfilRepository.save(perfil);
	}

	@Transactional
	public void excluir(Long perfilId) {
		// perfilRepository.detach(perfil);
		Optional<PerfilUsuario> perfilExistente = perfilRepository.findById(perfilId);
		if (perfilExistente.isPresent() && !perfilExistente.get().equals(perfilExistente)) {
			perfilRepository.deleteById(perfilId);
		}
	}

	@Transactional
	public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
		PerfilUsuario perfil = buscarOuFalhar(usuarioId);

		if (perfil.senhaNaoCoincideCom(senhaAtual)) {
			throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
		}

		perfil.setSenha(novaSenha);
	}

	@Transactional
	public void desassociarGrupo(Long perfilId, Long grupoId) {
		PerfilUsuario perfil = buscarOuFalhar(perfilId);
		GrupoUsuario grupo = cadastroGrupoUsuarioService.buscarOuFalhar(grupoId);

		perfil.removerGrupo(grupo);
	}

	@Transactional
	public void associarGrupo(Long perfilId, Long grupoId) {
		PerfilUsuario perfil = buscarOuFalhar(perfilId);
		GrupoUsuario grupo = cadastroGrupoUsuarioService.buscarOuFalhar(grupoId);

		perfil.adicionarGrupo(grupo);
	}

	public PerfilUsuario buscarOuFalhar(Long perfilId) {
		return perfilRepository.findById(perfilId)
				.orElseThrow(() -> new UsuarioNaoEncontradoException(perfilId));
	}

}
