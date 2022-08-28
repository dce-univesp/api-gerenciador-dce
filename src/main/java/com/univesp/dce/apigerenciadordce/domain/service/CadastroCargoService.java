package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.CargoNaoEncontradoException;
import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.model.Cargo;
import com.univesp.dce.apigerenciadordce.domain.repository.CargoRepository;

@Service
public class CadastroCargoService {
    
    @Autowired
	private CargoRepository cargoRepository;
	
    @Transactional
	public Cargo salvar(Cargo cargo) {
		//cargoRepository.detach(cargo);
		
		Optional<Cargo> cargoExistente = cargoRepository.findByNome(cargo.getNome());
		
		if (cargoExistente.isPresent() && !cargoExistente.get().equals(cargo)) {
			throw new NegocioException(
					String.format("Cargo já cadastrado: %s", cargo.getNome())
					);
		}
		
		return cargoRepository.save(cargo);
	}
	
	@Transactional
	public void excluir(Long cargoId) {
		//cargoRepository.detach(cargo);	
		Optional<Cargo> cargoExistente = cargoRepository.findById(cargoId);
		if (cargoExistente.isPresent() && !cargoExistente.get().equals(cargoExistente)) {
			cargoRepository.deleteById(cargoId);
		}
	}	

    public Cargo buscarOuFalhar(Long cargoId) {
		return cargoRepository.findById(cargoId)
				.orElseThrow(() -> new CargoNaoEncontradoException(cargoId));
	}
}
