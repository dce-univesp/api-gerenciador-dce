package com.univesp.dce.apigerenciadordce.domain.exception;

public class PermissaoNaoEncontradaException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public PermissaoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public PermissaoNaoEncontradaException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
