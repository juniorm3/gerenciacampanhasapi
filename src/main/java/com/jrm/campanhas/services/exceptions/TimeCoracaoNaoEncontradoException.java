package com.jrm.campanhas.services.exceptions;

public class TimeCoracaoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8185926923658465142L;

	public TimeCoracaoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public TimeCoracaoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
