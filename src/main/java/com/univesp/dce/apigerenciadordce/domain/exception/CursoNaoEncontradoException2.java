package com.univesp.dce.apigerenciadordce.domain.exception;

public class CursoNaoEncontradoException2 extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public CursoNaoEncontradoException2(String mensagem) {
        super(mensagem);
    }

    public CursoNaoEncontradoException2(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
