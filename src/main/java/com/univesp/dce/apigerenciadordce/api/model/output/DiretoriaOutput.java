package com.univesp.dce.apigerenciadordce.api.model.output;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class DiretoriaOutput {
    private Integer codigo;

    private String nome;

    private String descricao;

    private Date dataInicioMandado;

    private Date dataFimMandado;

    private Boolean ativo;
  
}
