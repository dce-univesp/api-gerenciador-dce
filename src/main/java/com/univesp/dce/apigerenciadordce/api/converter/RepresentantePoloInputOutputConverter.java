package com.univesp.dce.apigerenciadordce.api.converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.univesp.dce.apigerenciadordce.api.model.input.RepresentantePoloInput;
import com.univesp.dce.apigerenciadordce.api.model.output.RepresentantePoloOutput;
import com.univesp.dce.apigerenciadordce.domain.model.Polo;
import com.univesp.dce.apigerenciadordce.domain.model.RepresentantePolo;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RepresentantePoloInputOutputConverter {
    @Autowired
	private ModelMapper modelMapper;
	public RepresentantePolo convertInputToDomain(RepresentantePoloInput cidadeInput) {
		return modelMapper.map(cidadeInput, RepresentantePolo.class);
	}
	
	public void copyInputToDomain(RepresentantePoloInput representantePoloInput, RepresentantePolo representantePolo) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of 
		// com.univesp.dce.apigerenciadordce.domain.model.Eixo was altered from 1 to 2
		representantePolo.setPolo(new Polo());
		
		modelMapper.map(representantePoloInput, representantePolo);
	}

    
	public RepresentantePoloOutput convertDomainToOutput(RepresentantePolo representantePolo) {
		return modelMapper.map(representantePolo, RepresentantePoloOutput.class);
	}
	
	public List<RepresentantePoloOutput> convertDomainListToOutputList(Collection<RepresentantePolo> listaRepresentantePolos) {
		return listaRepresentantePolos.stream()
				//.map(RepresentantePolo -> convertDomainToOutput(RepresentantePolo))
                .map(this::convertDomainToOutput)
				.collect(Collectors.toList());
	}
}
