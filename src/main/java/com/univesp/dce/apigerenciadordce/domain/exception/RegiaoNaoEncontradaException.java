package com.univesp.dce.apigerenciadordce.domain.exception;

public class RegiaoNaoEncontradaException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public RegiaoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public RegiaoNaoEncontradaException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
