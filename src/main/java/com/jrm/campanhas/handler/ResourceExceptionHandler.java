package com.jrm.campanhas.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jrm.campanhas.domain.DetalhesErro;
import com.jrm.campanhas.services.exceptions.CampanhaNaoEncontradaException;
import com.jrm.campanhas.services.exceptions.TimeExistenteException;
import com.jrm.campanhas.services.exceptions.TimeNaoEncontradoException;

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

	@ExceptionHandler(TimeNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleTimeNaoEncontradoException(TimeNaoEncontradoException e,
			HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O time não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.times.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(TimeExistenteException.class)
	public ResponseEntity<DetalhesErro> handleTimeExistenteException(TimeExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Time já existente.");
		erro.setMensagemDesenvolvedor("http://erros.campanhas.com/409");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
}
