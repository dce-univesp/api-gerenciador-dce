package com.univesp.dce.apigerenciadordce.api.model;

import java.util.Date;

import com.univesp.dce.apigerenciadordce.domain.model.TipoRepresentantePolo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepresentantePoloModel {

    private Integer codigo;

    private TipoRepresentantePolo tipoRepresentantePolo;
    
    private PoloModel polo;
    
    private Boolean ativo;
    
    private Date dataInicioMandado;
    
    private Date dataFimMandado;
    
}
