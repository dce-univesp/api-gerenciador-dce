package com.univesp.dce.apigerenciadordce.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.PerfilUsuarioInput;
import com.univesp.dce.apigerenciadordce.api.model.output.PerfilUsuarioOutput;
import com.univesp.dce.apigerenciadordce.domain.model.PerfilUsuario;
import com.univesp.dce.apigerenciadordce.domain.model.Polo;
import com.univesp.dce.apigerenciadordce.domain.model.Curso;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PerfilUsuarioInputOutputConverter {
    @Autowired
    private ModelMapper modelMapper;

    public PerfilUsuario convertInputToDomain(PerfilUsuarioInput cidadeInput) {
        return modelMapper.map(cidadeInput, PerfilUsuario.class);
    }

    public void copyInputToDomain(PerfilUsuarioInput perfilUsuarioInput, PerfilUsuario perfilUsuario) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2
        perfilUsuario.setPolo(new Polo());
        perfilUsuario.setCurso(new Curso());

        modelMapper.map(perfilUsuarioInput, perfilUsuario);
    }

    public PerfilUsuarioOutput convertDomainToOutput(PerfilUsuario perfilUsuario) {
        return modelMapper.map(perfilUsuario, PerfilUsuarioOutput.class);
    }

    public List<PerfilUsuarioOutput> convertDomainListToOutputList(Collection<PerfilUsuario> listaPerfilUsuarios) {
        return listaPerfilUsuarios.stream()
                // .map(perfilUsuario -> convertDomainToOutput(perfilUsuario))
                .map(this::convertDomainToOutput)
                .collect(Collectors.toList());
    }
}
