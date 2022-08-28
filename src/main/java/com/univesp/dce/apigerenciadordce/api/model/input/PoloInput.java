package com.univesp.dce.apigerenciadordce.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PoloInput {

    @NotBlank
    private Integer codigo;

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    private String descricaoEndereco;
    
    @NotBlank
    private String descricaoContato;

    @NotBlank
    private Boolean flagUniceu;
    
    @NotBlank
    @NotNull
    private CidadeIdInput cidade;
    
    @NotBlank
    private Boolean ativo;
}
