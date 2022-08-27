package com.univesp.dce.apigerenciadordce.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GrupoUsuarioModel {
	private Long id;
	private String nome;
	private Boolean ativo;
	private String descricao;
}

