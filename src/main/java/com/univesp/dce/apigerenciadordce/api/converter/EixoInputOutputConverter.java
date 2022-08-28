package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.EixoInput;
import com.univesp.dce.apigerenciadordce.api.model.output.EixoOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Eixo;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EixoInputOutputConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Eixo convertInputToDomain(EixoInput eixoInput) {
        return modelMapper.map(eixoInput, Eixo.class);
    }

    public void copyInputToDomain(EixoInput eixoInput, Eixo eixo) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2

        modelMapper.map(eixoInput, eixo);
    }

    public EixoOutput convertDomainToOutput(Eixo eixo) {
        return modelMapper.map(eixo, EixoOutput.class);
    }

    public List<EixoOutput> convertDomainListToOutputList(Collection<Eixo> listaEixos) {
        return listaEixos.stream()
                // .map(eixo -> convertDomainToOutput(eixo))
                .map(this::convertDomainToOutput)
                .collect(Collectors.toList());
    }
}
