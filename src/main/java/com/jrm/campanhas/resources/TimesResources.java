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

import com.jrm.campanhas.domain.Time;
import com.jrm.campanhas.services.TimesServices;

@RestController
@RequestMapping("/times")
public class TimesResources {

	@Autowired
	private TimesServices timesService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Time>> listar() {
		List<Time> times = timesService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(times);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Time time) {
		time = timesService.salvar(time);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(time.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Time> buscar(@PathVariable("id") Long id) {
		Time time = timesService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(time);
	}

}
