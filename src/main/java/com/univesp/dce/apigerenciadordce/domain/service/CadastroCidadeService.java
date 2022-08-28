package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.exception.CidadeNaoEncontradaException;
import com.univesp.dce.apigerenciadordce.domain.model.Cidade;
import com.univesp.dce.apigerenciadordce.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	CidadeRepository cidadeRepository;

	@Transactional
	public Cidade salvar(Cidade cidade) {
		//CidadeRepository.detach(Cidade);
		
		Optional<Cidade> cidadeExistente = cidadeRepository.findByNome(cidade.getNome());
		
		if (cidadeExistente.isPresent() && !cidadeExistente.get().equals(cidade)) {
			throw new NegocioException(
					String.format("Cidade já cadastrado: %s", cidade.getNome()))
					;
		}
		
		return cidadeRepository.save(cidade);
	}
	
	@Transactional
	public void excluir(Long cidadeId) {
		//CidadeRepository.detach(Cidade);	
		Optional<Cidade> cidadeExistente = cidadeRepository.findById(cidadeId);
		if (cidadeExistente.isPresent() && !cidadeExistente.get().equals(cidadeExistente)) {
			cidadeRepository.deleteById(cidadeId);
		}
	}
	
	public Cidade buscarOuFalhar(Long cidadeId) {
		return cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new CidadeNaoEncontradaException(cidadeId));
	}
	
}

