package com.univesp.dce.apigerenciadordce.domain.model;

public enum SituacaoUsuario {
    ATIVO("A"),
    INATIVO("I"),
    SUSPENSO("S");

    private String descricao;

    SituacaoUsuario(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
}
