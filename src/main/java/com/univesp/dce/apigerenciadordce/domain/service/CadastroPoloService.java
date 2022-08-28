package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.exception.PoloNaoEncontradoException;
import com.univesp.dce.apigerenciadordce.domain.model.Polo;
import com.univesp.dce.apigerenciadordce.domain.repository.PoloRepository;

@Service
public class CadastroPoloService {
    
    @Autowired
	PoloRepository poloRepository;

	@Transactional
	public Polo salvar(Polo Polo) {
		//PoloRepository.detach(Polo);
		
		Optional<Polo> PoloExistente = poloRepository.findByNome(Polo.getNome());
		
		if (PoloExistente.isPresent() && !PoloExistente.get().equals(Polo)) {
			throw new NegocioException(
					String.format("Polo já cadastrado: %s", Polo.getNome())
					);
		}
		
		return poloRepository.save(Polo);
	}
	
	@Transactional
	public void excluir(Long PoloId) {
		//PoloRepository.detach(Polo);	
		Optional<Polo> PoloExistente = poloRepository.findById(PoloId);
		if (PoloExistente.isPresent() && !PoloExistente.get().equals(PoloExistente)) {
			poloRepository.deleteById(PoloId);
		}
	}

    public Polo buscarOuFalhar(Long poloId) {
      return poloRepository.findById(poloId)
          .orElseThrow(() -> new PoloNaoEncontradoException(poloId));
    }
}

