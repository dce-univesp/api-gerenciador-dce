package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.NepInput;
import com.univesp.dce.apigerenciadordce.api.model.output.NepOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Nep;
import com.univesp.dce.apigerenciadordce.domain.model.PerfilUsuario;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NepInputOutputConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Nep convertInputToDomain(NepInput cidadeInput) {
        return modelMapper.map(cidadeInput, Nep.class);
    }

    public void copyInputToDomain(NepInput nepInput, Nep nep) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2
        nep.setPerfil(new PerfilUsuario());

        modelMapper.map(nepInput, nep);
    }

    public NepOutput convertDomainToOutput(Nep pep) {
        return modelMapper.map(pep, NepOutput.class);
    }

    public List<NepOutput> convertDomainListToOutputList(Collection<Nep> listaNeps) {
        return listaNeps.stream()
                // .map(Nep -> convertDomainToOutput(Nep))
                .map(this::convertDomainToOutput)
                .collect(Collectors.toList());
    }

}
