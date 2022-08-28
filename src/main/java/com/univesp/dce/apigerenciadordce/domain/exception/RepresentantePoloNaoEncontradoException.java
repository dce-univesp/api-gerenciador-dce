package com.univesp.dce.apigerenciadordce.domain.exception;

public class RepresentantePoloNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public RepresentantePoloNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public RepresentantePoloNaoEncontradoException(Long reprentantePoloId) {
        this(String.format("Não existe um representante de Polo com código %d", reprentantePoloId));
    }
}
