package com.univesp.dce.apigerenciadordce.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CursoModel {
    private Integer codigo;

      private String nome;
  
      private String sigla;
  
      private String descricao;
  
      private String linkGrade;
  
      private String linkPPC;
  
      private Boolean ativo;
  
      private EixoModel eixo;
}
