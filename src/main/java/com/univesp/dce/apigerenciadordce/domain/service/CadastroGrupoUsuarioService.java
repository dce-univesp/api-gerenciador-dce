package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.EntidadeEmUsoException;
import com.univesp.dce.apigerenciadordce.domain.exception.GrupoNaoEncontradoException;
import com.univesp.dce.apigerenciadordce.domain.model.GrupoUsuario;
import com.univesp.dce.apigerenciadordce.domain.model.Permissao;
import com.univesp.dce.apigerenciadordce.domain.repository.GrupoUsuarioRepository;

@Service
public class CadastroGrupoUsuarioService {

	private static final String MSG_GRUPO_EM_USO = "Grupo de código %d não pode ser removido, pois está em uso";

	@Autowired
	private GrupoUsuarioRepository grupoUsuarioRepository;

	@Autowired
	private CadastroPermissaoService cadastroPermissao;

	@Transactional
	public GrupoUsuario salvar(GrupoUsuario grupo) {
		return grupoUsuarioRepository.save(grupo);
	}

	@Transactional
	public void excluir(Long grupoId) {
		try {
			grupoUsuarioRepository.deleteById(grupoId);
			grupoUsuarioRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new GrupoNaoEncontradoException(grupoId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_GRUPO_EM_USO, grupoId));
		}
	}

	@Transactional
	public void desassociarPermissao(Long grupoId, Long permissaoId) {
		GrupoUsuario grupo = buscarOuFalhar(grupoId);
		Permissao permissao = cadastroPermissao.buscarOuFalhar(permissaoId);

		grupo.removerPermissao(permissao);
	}

	@Transactional
	public void associarPermissao(Long grupoId, Long permissaoId) {
		GrupoUsuario grupo = buscarOuFalhar(grupoId);
		Permissao permissao = cadastroPermissao.buscarOuFalhar(permissaoId);

		grupo.adicionarPermissao(permissao);
	}

	public GrupoUsuario buscarOuFalhar(Long grupoId) {
		return grupoUsuarioRepository.findById(grupoId)
				.orElseThrow(() -> new GrupoNaoEncontradoException(grupoId));
	}

	public List<GrupoUsuario> listar() {
		return grupoUsuarioRepository.findAll();
	}

}
