package com.univesp.dce.apigerenciadordce.api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.univesp.dce.apigerenciadordce.api.converter.CargoInputOutputConverter;

import com.univesp.dce.apigerenciadordce.api.model.input.CargoInput;
import com.univesp.dce.apigerenciadordce.api.model.output.CargoOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Cargo;

import com.univesp.dce.apigerenciadordce.domain.repository.CargoRepository;
import com.univesp.dce.apigerenciadordce.domain.service.CadastroCargoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/cargo")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private CadastroCargoService cadastroCargoService;

	@Autowired
	private CargoInputOutputConverter cargoInputOutputConverter;

	@GetMapping
	public List<CargoOutput> listar() {
		List<Cargo> listaCargos = cargoRepository.findAll();
		return cargoInputOutputConverter.convertDomainListToOutputList(listaCargos);
	}

	@GetMapping("/{cargoId}")
	public CargoOutput buscar(@PathVariable Long cargoId) {
		Cargo Cargo = cadastroCargoService.buscarOuFalhar(cargoId);
		return cargoInputOutputConverter.convertDomainToOutput(Cargo);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CargoOutput adicionar(@RequestBody /* @Valid */ CargoInput cargoInput) {
		Cargo cargo = cargoInputOutputConverter.convertInputToDomain(cargoInput);
		cargo = cadastroCargoService.salvar(cargo);
		return cargoInputOutputConverter.convertDomainToOutput(cargo);
	}

	@PutMapping("/{cargoId}")
	public CargoOutput atualizar(@PathVariable Long cargoId, @RequestBody /* @Valid */ CargoInput cargoInput) {
		Cargo cargoAtual = cadastroCargoService.buscarOuFalhar(cargoId);
		cargoInputOutputConverter.copyInputToDomain(cargoInput, cargoAtual);
		cargoAtual = cadastroCargoService.salvar(cargoAtual);
		return cargoInputOutputConverter.convertDomainToOutput(cargoAtual);
	}

	@DeleteMapping("/{cargoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirCargo(@PathVariable Long cargoId) {
		cadastroCargoService.excluir(cargoId);
	}

}
