package com.jrm.campanhas.services.exceptions;

public class TimeNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8185926923658465142L;

	public TimeNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public TimeNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
