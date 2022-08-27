package com.univesp.dce.apigerenciadordce.domain.exception;

public class CargoNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public CargoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public CargoNaoEncontradoException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de usuário com código %d", cozinhaId));
    }
}
