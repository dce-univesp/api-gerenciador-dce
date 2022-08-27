package com.univesp.dce.apigerenciadordce.domain.model;

public enum TipoUsuario {
    ADMINISTRADOR("A"),
    EDITOR("E"),
    USUARIO("U");

    private String descricao;

    TipoUsuario(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
