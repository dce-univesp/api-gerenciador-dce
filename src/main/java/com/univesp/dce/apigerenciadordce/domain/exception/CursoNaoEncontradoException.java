package com.univesp.dce.apigerenciadordce.domain.exception;

public class CursoNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public CursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public CursoNaoEncontradoException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
