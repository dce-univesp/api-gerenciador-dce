package com.univesp.dce.apigerenciadordce.domain.exception;

public class DiretoriaNaoEncontradaException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public DiretoriaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public DiretoriaNaoEncontradaException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
