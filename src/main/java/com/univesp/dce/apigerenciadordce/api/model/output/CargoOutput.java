package com.univesp.dce.apigerenciadordce.api.model.output;

import com.univesp.dce.apigerenciadordce.api.model.input.CargoInput;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CargoOutput {
 
    private Integer codigo;
    private String nome;  
    private String descricao;
}
