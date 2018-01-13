package com.jrm.campanhas.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jrm.campanhas.domain.DetalhesErro;
import com.jrm.campanhas.services.exceptions.CampanhaNaoEncontradaException;
import com.jrm.campanhas.services.exceptions.TimeCoracaoExistenteException;
import com.jrm.campanhas.services.exceptions.TimeCoracaoNaoEncontradoException;

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

	@ExceptionHandler(TimeCoracaoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleTimeNaoEncontradoException(TimeCoracaoNaoEncontradoException e,
			HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O time não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.times.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(TimeCoracaoExistenteException.class)
	public ResponseEntity<DetalhesErro> handleTimeExistenteException(TimeCoracaoExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Time já existente.");
		erro.setMensagemDesenvolvedor("http://erros.campanhas.com/409");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida.");
		erro.setMensagemDesenvolvedor("http://erros.campanhas.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST ).body(erro);
	}
}
