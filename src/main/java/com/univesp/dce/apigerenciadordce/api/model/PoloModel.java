package com.univesp.dce.apigerenciadordce.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PoloModel {
    private Integer codigo;

    private String nome;
      
    private String descricaoEndereco;
      
    private String descricaoContato;
   
    private Boolean flagUniceu;
  
    private CidadeModel cidade;
  
    private Boolean ativo;
}

