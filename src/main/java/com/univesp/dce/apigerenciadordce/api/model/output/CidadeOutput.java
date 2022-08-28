package com.univesp.dce.apigerenciadordce.api.model.output;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CidadeOutput {

	private Long id;
	private String nome;
	private RegiaoOutput regiao;
	
}

