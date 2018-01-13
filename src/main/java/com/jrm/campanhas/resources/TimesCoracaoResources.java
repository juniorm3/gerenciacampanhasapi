package com.jrm.campanhas.resources;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jrm.campanhas.domain.TimeCoracao;
import com.jrm.campanhas.services.TimesCoracaoServices;

@RestController
@RequestMapping("/times")
public class TimesCoracaoResources {

	@Autowired
	private TimesCoracaoServices timesService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TimeCoracao>> listar() {
		List<TimeCoracao> times = timesService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(times);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody TimeCoracao time) {
		time = timesService.salvar(time);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(time.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TimeCoracao> buscar(@PathVariable("id") Long id) {
		TimeCoracao time = timesService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(time);
	}

}
