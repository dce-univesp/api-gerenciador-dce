package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.GrupoUsuarioInput;
import com.univesp.dce.apigerenciadordce.api.model.output.GrupoUsuarioOutput;
import com.univesp.dce.apigerenciadordce.domain.model.GrupoUsuario;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GrupoUsuarioInputOutputConverter {
    @Autowired
    private ModelMapper modelMapper;

    public GrupoUsuario convertInputToDomain(GrupoUsuarioInput grupoUsuarioInput) {
        return modelMapper.map(grupoUsuarioInput, GrupoUsuario.class);
    }

    public void copyInputToDomain(GrupoUsuarioInput grupoUsuarioInput, GrupoUsuario grupoUsuario) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2

        modelMapper.map(grupoUsuarioInput, grupoUsuario);
    }

    public GrupoUsuarioOutput convertDomainToOutput(GrupoUsuario grupoUsuario) {
        return modelMapper.map(grupoUsuario, GrupoUsuarioOutput.class);
    }

    public List<GrupoUsuarioOutput> convertDomainListToOutputList(Collection<GrupoUsuario> listaGrupoUsuarios) {
        return listaGrupoUsuarios.stream()
                // .map(grupoUsuario -> convertDomainToOutput(grupoUsuario))
                .map(this::convertDomainToOutput)
                .collect(Collectors.toList());
    }
}
