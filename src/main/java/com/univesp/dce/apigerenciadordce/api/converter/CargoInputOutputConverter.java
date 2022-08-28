package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.CargoInput;
import com.univesp.dce.apigerenciadordce.api.model.output.CargoOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Cargo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Component
public class CargoInputOutputConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Cargo convertInputToDomain(CargoInput cargoInput) {
        return modelMapper.map(cargoInput, Cargo.class);
    }

    public void copyInputToDomain(CargoInput cargoInput, Cargo cargo) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.univesp.dce.apigerenciadordce.domain.model.Estado was altered from 1 to 2

        modelMapper.map(cargoInput, cargo);
    }

    public CargoOutput convertDomainToOutput(Cargo cargo) {
        return modelMapper.map(cargo, CargoOutput.class);
    }

    public List<CargoOutput> convertDomainListToOutputList(Collection<Cargo> listaCargos) {
        return listaCargos.stream()
                // .map(cargo -> convertDomainToOutput(cargo))
                .map(this::convertDomainToOutput)
                .collect(Collectors.toList());
    }

}
