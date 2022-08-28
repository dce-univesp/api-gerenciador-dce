package com.univesp.dce.apigerenciadordce.api.model.input;

import java.util.Date;

import com.univesp.dce.apigerenciadordce.domain.model.TipoRepresentantePolo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepresentantePoloInput {
   
    private TipoRepresentantePolo tipoRepresentantePolo;
    
    private PoloIdInput polo;
    
    private Boolean ativo;
    
    private Date dataInicioMandado;
    
    private Date dataFimMandado;
}
