package com.univesp.dce.apigerenciadordce.domain.model;

public enum TipoNep {

    NOTICIA("N"),
    EVENTO("E"),
    PROJETO("P");

    private String descricao;

    TipoNep(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
}
