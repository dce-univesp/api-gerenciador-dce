package com.univesp.dce.apigerenciadordce.api.model.input;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiretoriaInput {
    
    private String nome;

    private String descricao;

    private Date dataInicioMandado;

    private Date dataFimMandado;

    private Boolean ativo;
}
