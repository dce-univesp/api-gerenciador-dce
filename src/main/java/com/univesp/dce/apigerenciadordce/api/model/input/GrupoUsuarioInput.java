package com.univesp.dce.apigerenciadordce.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoUsuarioInput {
    @NotBlank
    public String nome;
    private Boolean ativo;
    private String descricao;
}
