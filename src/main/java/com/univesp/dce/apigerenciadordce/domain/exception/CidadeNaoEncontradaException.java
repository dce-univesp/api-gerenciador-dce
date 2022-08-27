package com.univesp.dce.apigerenciadordce.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException{

	
	private static final long serialVersionUID = 1L;

	public CidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CidadeNaoEncontradaException(Long estadoId) {
		this(String.format("Não existe um cadastro de estado com código %d", estadoId));
	}
}
