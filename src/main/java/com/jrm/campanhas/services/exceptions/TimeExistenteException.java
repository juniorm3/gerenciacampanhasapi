package com.jrm.campanhas.services.exceptions;

public class TimeExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8185926923658465142L;

	public TimeExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public TimeExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
