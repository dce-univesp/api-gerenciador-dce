package com.univesp.dce.apigerenciadordce.api.model.input;

import java.time.OffsetDateTime;

import com.univesp.dce.apigerenciadordce.domain.model.SituacaoNep;
import com.univesp.dce.apigerenciadordce.domain.model.TipoNep;
import com.univesp.dce.apigerenciadordce.domain.model.TipoVisibilidadeNep;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NepInput {

    private String titulo;

    private String subTitulo;

    private OffsetDateTime dataPublicacao;

    private String descricaoPostagem;

    private Boolean ativo;

    private PerfilUsuarioIdInput perfil;

    private TipoNep tipoNep;

    private TipoVisibilidadeNep tipoAbrangenciaNep;

    private SituacaoNep situacaoNep;
}
