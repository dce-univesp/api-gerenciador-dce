package com.univesp.dce.apigerenciadordce.api.model.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PoloOutput {
    private Integer codigo;

    private String nome;
      
    private String descricaoEndereco;
      
    private String descricaoContato;
   
    private Boolean flagUniceu;
  
    private CidadeOutput cidade;
  
    private Boolean ativo;
}

