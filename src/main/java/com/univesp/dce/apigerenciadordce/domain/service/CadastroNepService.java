package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.exception.NepNaoEncontradoException;
import com.univesp.dce.apigerenciadordce.domain.model.Nep;
import com.univesp.dce.apigerenciadordce.domain.repository.NepRepository;

@Service
public class CadastroNepService {
    @Autowired
    NepRepository nepRepository;

    @Transactional
    public Nep salvar(Nep nep) {
        // NepRepository.detach(Nep);

        Optional<Nep> nepExistente = nepRepository.findByTitulo(nep.getTitulo());

        if (nepExistente.isPresent() && !nepExistente.get().equals(nep)) {
            throw new NegocioException(
                    String.format("Nep já cadastrado: %s", nep.getTitulo()));
        }

        return nepRepository.save(nep);
    }

    @Transactional
	public void excluir(Long NepId) {
		//NepRepository.detach(Nep);	
		Optional<Nep> NepExistente = nepRepository.findById(NepId);
		if (NepExistente.isPresent() && !NepExistente.get().equals(NepExistente)) {
			nepRepository.deleteById(NepId);
		}
	}

    public Nep buscarOuFalhar(Long nepId) {
        return nepRepository.findById(nepId)
            .orElseThrow(() -> new NepNaoEncontradoException(nepId));
      }
}
