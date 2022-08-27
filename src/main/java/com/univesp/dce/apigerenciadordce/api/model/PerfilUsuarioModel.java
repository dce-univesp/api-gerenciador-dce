package com.univesp.dce.apigerenciadordce.api.model;


import com.univesp.dce.apigerenciadordce.api.model.input.PoloInput;
import com.univesp.dce.apigerenciadordce.domain.model.SituacaoUsuario;
import com.univesp.dce.apigerenciadordce.domain.model.TipoUsuario;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PerfilUsuarioModel {

	private Integer codigo;
    private String emailAcademico; // login    
    private String nomeUsuario;
    private Boolean ativo;
    private Integer anoTurmaIngresso;
    private Integer numeroSemestreIngresso;
    private String emailPessoal;
    private String usuarioTelegram;
    private PoloInput polo;
    private String descricaoContato;
    private TipoUsuario tipoUsuario;
    private SituacaoUsuario situacaoUsuario;   
}
