package com.univesp.dce.apigerenciadordce.domain.exception;

public class PoloNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public PoloNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public PoloNaoEncontradoException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
