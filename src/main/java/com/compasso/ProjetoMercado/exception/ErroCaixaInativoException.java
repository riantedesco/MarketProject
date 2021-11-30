package com.compasso.ProjetoMercado.exception;

public class ErroCaixaInativoException extends RuntimeException {

	private static final long serialVersionUID = -8802565387705835064L;

	public ErroCaixaInativoException (String mensagem) {
		super(mensagem);
	}
}
