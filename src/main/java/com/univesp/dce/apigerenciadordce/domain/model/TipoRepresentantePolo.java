package com.univesp.dce.apigerenciadordce.domain.model;

public enum TipoRepresentantePolo {

    TITULAR("T"),
    SUPLENTE("S");

    private String descricao;

    TipoRepresentantePolo(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
}
