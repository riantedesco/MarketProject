package com.compasso.ProjetoMercado.exception;

public class ErroDadosNulosException extends RuntimeException {

	private static final long serialVersionUID = -8802565387705835064L;

	public ErroDadosNulosException (String mensagem) {
		super(mensagem);
	}
}
