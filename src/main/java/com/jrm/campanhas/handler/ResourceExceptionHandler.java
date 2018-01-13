package com.jrm.campanhas.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jrm.campanhas.domain.DetalhesErro;
import com.jrm.campanhas.services.exceptions.CampanhaNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(CampanhaNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleCampanhaNaoEncontradaException(CampanhaNaoEncontradaException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("A campanha não pode ser encontrada.");
		erro.setMensagemDesenvolvedor("http://erros.campanhas.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
