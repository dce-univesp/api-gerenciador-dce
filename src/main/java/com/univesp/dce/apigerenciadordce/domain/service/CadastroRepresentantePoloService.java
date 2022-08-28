package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.exception.RepresentantePoloNaoEncontradoException;
import com.univesp.dce.apigerenciadordce.domain.model.RepresentantePolo;
import com.univesp.dce.apigerenciadordce.domain.repository.RepresentantePoloRepository;

@Service
public class CadastroRepresentantePoloService {

    @Autowired
    RepresentantePoloRepository representantePoloRepository;

    @Transactional
	public RepresentantePolo salvar(RepresentantePolo representantePolo) {
		//RepresentantePoloRepository.detach(RepresentantePolo);
		
		Optional<RepresentantePolo> representantePoloExistente = representantePoloRepository.findById(representantePolo.getCodigo().longValue());
		
		if (representantePoloExistente.isPresent() && !representantePoloExistente.get().equals(representantePolo)) {
			throw new NegocioException(
					    String.format("Representante Polo já cadastrado: %s", representantePolo.getCodigo())
                    );
		}
		return representantePoloRepository.save(representantePolo);
	}

    @Transactional
    public void excluir(Long RepresentantePoloId) {
        // RepresentantePoloRepository.detach(RepresentantePolo);
        Optional<RepresentantePolo> RepresentantePoloExistente = representantePoloRepository
                .findById(RepresentantePoloId);
        if (RepresentantePoloExistente.isPresent()
                && !RepresentantePoloExistente.get().equals(RepresentantePoloExistente)) {
                    representantePoloRepository.deleteById(RepresentantePoloId);
        }
    }

    public RepresentantePolo buscarOuFalhar(Long cursoId) {
        return representantePoloRepository.findById(cursoId)
            .orElseThrow(() -> new RepresentantePoloNaoEncontradoException(cursoId));
    }
}
