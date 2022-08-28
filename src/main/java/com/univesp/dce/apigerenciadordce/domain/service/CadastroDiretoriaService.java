package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.DiretoriaNaoEncontradaException;
import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.model.Diretoria;
import com.univesp.dce.apigerenciadordce.domain.repository.DiretoriaRepository;

@Service
public class CadastroDiretoriaService {
    @Autowired
    DiretoriaRepository diretoriaRepository;

    @Transactional
	public Diretoria salvar(Diretoria Diretoria) {
		//DiretoriaRepository.detach(Diretoria);
		
		Optional<Diretoria> DiretoriaExistente = diretoriaRepository.findByNome(Diretoria.getNome());
		
		if (DiretoriaExistente.isPresent() && !DiretoriaExistente.get().equals(Diretoria)) {
			throw new NegocioException(
					String.format("Diretoria já cadastrado: %s", Diretoria.getNome())
                    );
		}
		
		return diretoriaRepository.save(Diretoria);
	}

    @Transactional
    public void excluir(Long DiretoriaId) {
        // DiretoriaRepository.detach(Diretoria);
        Optional<Diretoria> DiretoriaExistente = diretoriaRepository.findById(DiretoriaId);
        if (DiretoriaExistente.isPresent() && !DiretoriaExistente.get().equals(DiretoriaExistente)) {
            diretoriaRepository.deleteById(DiretoriaId);
        }
    }

    public Diretoria buscarOuFalhar(Long diretoriaId) {
      return diretoriaRepository.findById(diretoriaId)
          .orElseThrow(() -> new DiretoriaNaoEncontradaException(diretoriaId));
    }
}
