package com.univesp.dce.apigerenciadordce.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PerfilUsuarioComSenhaInput extends PerfilUsuarioInput{
    @NotBlank   
    private String senha;
}
