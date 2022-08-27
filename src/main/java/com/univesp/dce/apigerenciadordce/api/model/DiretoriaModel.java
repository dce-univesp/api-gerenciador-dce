package com.univesp.dce.apigerenciadordce.api.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class DiretoriaModel {
    private Integer codigo;

    private String nome;

    private String descricao;

    private Date dataInicioMandado;

    private Date dataFimMandado;

    private Boolean ativo;
  
}
