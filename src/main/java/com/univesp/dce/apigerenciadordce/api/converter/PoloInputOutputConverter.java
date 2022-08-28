package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.PoloInput;
import com.univesp.dce.apigerenciadordce.api.model.output.PoloOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Cidade;
import com.univesp.dce.apigerenciadordce.domain.model.Polo;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PoloInputOutputConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Polo convertInputToDomain(PoloInput cidadeInput) {
        return modelMapper.map(cidadeInput, Polo.class);
    }

    public void copyInputToDomain(PoloInput poloInput, Polo polo) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2
        polo.setCidade(new Cidade());

        modelMapper.map(poloInput, polo);
    }

    public PoloOutput convertDomainToOutput(Polo polo) {
        return modelMapper.map(polo, PoloOutput.class);
    }

    public List<PoloOutput> convertDomainListToOutputList(Collection<Polo> listaPolos) {
        return listaPolos.stream()
                // .map(polo -> convertDomainToOutput(polo))
                .map(this::convertDomainToOutput)
                .collect(Collectors.toList());
    }
}
