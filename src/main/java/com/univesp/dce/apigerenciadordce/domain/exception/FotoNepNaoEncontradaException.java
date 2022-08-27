package com.univesp.dce.apigerenciadordce.domain.exception;

public class FotoNepNaoEncontradaException extends EntidadeNaoEncontradaException{
	private static final long serialVersionUID = 1L;

	public FotoNepNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public FotoNepNaoEncontradaException(Long restauranteId, Long produtoId) {
		this(String.format("Não existe um cadastro de foto do produto com código %d para o restaurante de código %d",
				produtoId, restauranteId));
	}

}
