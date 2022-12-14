package com.univesp.dce.apigerenciadordce.api.model.input;

import com.univesp.dce.apigerenciadordce.domain.model.Polo;
import com.univesp.dce.apigerenciadordce.domain.model.SituacaoUsuario;
import com.univesp.dce.apigerenciadordce.domain.model.TipoUsuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilUsuarioInput {
    
    private Integer codigo;
    private String emailAcademico; // login    
    private String nomeUsuario;
    private Boolean ativo;
    private Integer anoTurmaIngresso;
    private Integer numeroSemestreIngresso;
    private String emailPessoal;
    private String usuarioTelegram;
    private PoloIdInput polo;
    private String descricaoContato;
    private TipoUsuario tipoUsuario;
    private SituacaoUsuario situacaoUsuario;   
}
