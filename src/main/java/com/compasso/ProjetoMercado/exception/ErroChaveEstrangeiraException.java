package com.compasso.ProjetoMercado.exception;

public class ErroChaveEstrangeiraException extends RuntimeException {

	private static final long serialVersionUID = -8802565387705835064L;

	public ErroChaveEstrangeiraException (String mensagem) {
		super(mensagem);
	}
}
