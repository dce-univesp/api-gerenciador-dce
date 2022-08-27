package com.univesp.dce.apigerenciadordce.domain.exception;

public class NepNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public NepNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public NepNaoEncontradoException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
