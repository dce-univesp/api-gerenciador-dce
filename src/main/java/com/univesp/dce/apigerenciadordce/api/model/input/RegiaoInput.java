package com.univesp.dce.apigerenciadordce.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegiaoInput {

    @NotBlank
    private Integer codigo;
    
    @NotBlank
    private String nome;
    
}
