package com.univesp.dce.apigerenciadordce.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;
import com.univesp.dce.apigerenciadordce.domain.model.SituacaoNep;
import com.univesp.dce.apigerenciadordce.domain.model.TipoNep;
import com.univesp.dce.apigerenciadordce.domain.model.TipoVisibilidadeNep;

@Setter
@Getter
public class NepModel {
    private Integer codigo;

    private String titulo;

    private String subTitulo;

    private OffsetDateTime dataPublicacao;

    private String descricaoPostagem;

    private Boolean ativo;

    private PerfilUsuarioModel perfil;

    private TipoNep tipoNep;

    private TipoVisibilidadeNep tipoAbrangenciaNep;

    private SituacaoNep situacaoNep;
}
