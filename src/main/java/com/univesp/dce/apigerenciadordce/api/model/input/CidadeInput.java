package com.univesp.dce.apigerenciadordce.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInput {
    private Integer codigo;

    private String nome;

    private RegiaoInput regiao;

}
