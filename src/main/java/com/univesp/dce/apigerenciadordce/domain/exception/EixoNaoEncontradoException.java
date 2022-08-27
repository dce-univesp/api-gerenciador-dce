package com.univesp.dce.apigerenciadordce.domain.exception;

public class EixoNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public EixoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public EixoNaoEncontradoException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
