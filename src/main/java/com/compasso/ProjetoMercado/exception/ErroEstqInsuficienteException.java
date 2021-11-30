package com.compasso.ProjetoMercado.exception;

public class ErroEstqInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = -8802565387705835064L;

	public ErroEstqInsuficienteException (String mensagem) {
		super(mensagem);
	}
}
