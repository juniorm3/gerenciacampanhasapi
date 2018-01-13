package com.jrm.campanhas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jrm.campanhas.domain.Campanha;
import com.jrm.campanhas.services.CampanhasService;
import com.jrm.campanhas.services.exceptions.CampanhaNaoEncontradaException;

@RestController
@RequestMapping("/campanhas")
public class CampanhasResource {

	@Autowired
	private CampanhasService campanhasService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Campanha>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(campanhasService.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Campanha campanha) {
		campanha = campanhasService.salvar(campanha);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(campanha.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Campanha campanha = null;
		try {
			campanha = campanhasService.buscar(id);
		} catch (CampanhaNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(campanha);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		try {
			campanhasService.deletar(id);
		} catch (CampanhaNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Campanha campanha, @PathVariable("id") Long id) {
		campanha.setId(id);
		try {
			campanhasService.atualizar(campanha);
		} catch (CampanhaNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
}
