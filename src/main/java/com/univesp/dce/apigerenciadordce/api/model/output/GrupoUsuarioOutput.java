package com.univesp.dce.apigerenciadordce.api.model.output;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GrupoUsuarioOutput {
	private Long id;
	private String nome;
	private Boolean ativo;
	private String descricao;
}

