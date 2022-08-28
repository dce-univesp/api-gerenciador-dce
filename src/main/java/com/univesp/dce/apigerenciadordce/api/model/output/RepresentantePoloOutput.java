package com.univesp.dce.apigerenciadordce.api.model.output;

import java.sql.Date;

import com.univesp.dce.apigerenciadordce.domain.model.TipoRepresentantePolo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepresentantePoloOutput {

    private Integer codigo;

    private TipoRepresentantePolo tipoRepresentantePolo;
    
    private PoloOutput polo;
    
    private Boolean ativo;
    
    private Date dataInicioMandado;
    
    private Date dataFimMandado;
    
    
}
