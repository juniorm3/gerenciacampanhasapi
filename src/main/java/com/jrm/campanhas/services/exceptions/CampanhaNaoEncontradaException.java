package com.jrm.campanhas.services.exceptions;

public class CampanhaNaoEncontradaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8185926923658465142L;

	public CampanhaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CampanhaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
