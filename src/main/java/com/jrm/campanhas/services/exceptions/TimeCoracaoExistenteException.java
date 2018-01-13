package com.jrm.campanhas.services.exceptions;

public class TimeCoracaoExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8185926923658465142L;

	public TimeCoracaoExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public TimeCoracaoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
