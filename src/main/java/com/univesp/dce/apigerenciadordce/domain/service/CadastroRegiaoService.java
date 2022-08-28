package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.exception.RegiaoNaoEncontradaException;
import com.univesp.dce.apigerenciadordce.domain.model.Regiao;
import com.univesp.dce.apigerenciadordce.domain.repository.RegiaoRepository;

@Service
public class CadastroRegiaoService {
    @Autowired
    RegiaoRepository regiaoRepository;

    @Transactional
	public Regiao salvar(Regiao regiao) {
		//RegiaoRepository.detach(Regiao);
		
		Optional<Regiao> RegiaoExistente = regiaoRepository.findByNome(regiao.getNome());
		
		if (RegiaoExistente.isPresent() && !RegiaoExistente.get().equals(regiao)) {
			throw new NegocioException(
					    String.format("Regiao já cadastrada: %s", regiao.getNome())
                    );
		}
		return regiaoRepository.save(regiao);
	}

    @Transactional
    public void excluir(Long RegiaoId) {
        // RegiaoRepository.detach(Regiao);
        Optional<Regiao> RegiaoExistente = regiaoRepository.findById(RegiaoId);
        if (RegiaoExistente.isPresent() && !RegiaoExistente.get().equals(RegiaoExistente)) {
            regiaoRepository.deleteById(RegiaoId);
        }
    }

    public Regiao buscarOuFalhar(Long regiaoId) {
        return regiaoRepository.findById(regiaoId)
            .orElseThrow(() -> new RegiaoNaoEncontradaException(regiaoId));
    }
}

