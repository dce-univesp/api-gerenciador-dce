package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.RegiaoInput;
import com.univesp.dce.apigerenciadordce.api.model.output.RegiaoOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Regiao;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegiaoInputOutputConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Regiao convertInputToDomain(RegiaoInput cidadeInput) {
        return modelMapper.map(cidadeInput, Regiao.class);
    }

    public void copyInputToDomain(RegiaoInput regiaoInput, Regiao regiao) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2

        modelMapper.map(regiaoInput, regiao);
    }

    public RegiaoOutput convertDomainToOutput(Regiao regiao) {
        return modelMapper.map(regiao, RegiaoOutput.class);
    }

    public List<RegiaoOutput> convertDomainListToOutputList(Collection<Regiao> listaRegioes) {
        return listaRegioes.stream()
                // .map(regiao -> convertDomainToOutput(regiao))
                .map(this::convertDomainToOutput)
                .collect(Collectors.toList());
    }
}
