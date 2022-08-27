package com.univesp.dce.apigerenciadordce.domain.model;

public enum TipoVisibilidadeNep {
    GERAL("G"),
    POLO("P");

    private String descricao;

    TipoVisibilidadeNep(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }

}
