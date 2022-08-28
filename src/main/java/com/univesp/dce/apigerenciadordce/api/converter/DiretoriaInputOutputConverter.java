package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.DiretoriaInput;
import com.univesp.dce.apigerenciadordce.api.model.output.DiretoriaOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Diretoria;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Component
public class DiretoriaInputOutputConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Diretoria convertInputToDomain(DiretoriaInput diretoriaInput) {
        return modelMapper.map(diretoriaInput, Diretoria.class);
    }

    public void copyInputToDomain(DiretoriaInput diretoriaInput, Diretoria diretoria) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2

        modelMapper.map(diretoriaInput, diretoria);
    }

    public DiretoriaOutput convertDomainToOutput(Diretoria diretoria) {
        return modelMapper.map(diretoria, DiretoriaOutput.class);
    }

    public List<DiretoriaOutput> convertDomainListToOutputList(Collection<Diretoria> listaDiretorias) {
        return listaDiretorias.stream()
                // .map(Diretoria -> convertDomainToOutput(Diretoria))
                .map(this::convertDomainToOutput)
                .collect(Collectors.toList());
    }
}
