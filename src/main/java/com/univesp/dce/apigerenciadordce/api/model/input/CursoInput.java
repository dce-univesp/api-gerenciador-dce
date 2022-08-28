package com.univesp.dce.apigerenciadordce.api.model.input;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoInput {
    
    private String nome;

    private String sigla;

    private String descricao;

    private String linkGrade;

    private String linkPPC;

    private Boolean ativo;

    private EixoIdInput eixo;

}
