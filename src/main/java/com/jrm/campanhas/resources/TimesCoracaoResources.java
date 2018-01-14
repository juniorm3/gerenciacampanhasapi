package com.jrm.campanhas.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
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
		
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(times);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody TimeCoracao time) {
		time = timesService.salvar(time);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(time.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TimeCoracao> buscar(@PathVariable("id") Long id) {
		TimeCoracao time = timesService.buscar(id);
		
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(time);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@Valid @RequestBody TimeCoracao timeCoracao, @PathVariable("id") Long id){
		timeCoracao.setId(id);
		timesService.atualizar(timeCoracao);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		timesService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
