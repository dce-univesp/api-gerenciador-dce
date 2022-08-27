package com.univesp.dce.apigerenciadordce.domain.model;

public enum SituacaoNep {

    PUBLICADO("P"),
    CADASTRADO("C"),
    REVISADO("R"),
    EXCLUIDO("E");

    private String descricao;

    SituacaoNep(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
}
