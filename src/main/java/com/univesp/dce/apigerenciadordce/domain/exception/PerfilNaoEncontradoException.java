package com.univesp.dce.apigerenciadordce.domain.exception;

public class PerfilNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public PerfilNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public PerfilNaoEncontradoException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
