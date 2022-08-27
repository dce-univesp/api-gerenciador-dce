package com.univesp.dce.apigerenciadordce.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CidadeModel {

	private Long id;
	private String nome;
	private RegiaoModel regiao;
	
}

