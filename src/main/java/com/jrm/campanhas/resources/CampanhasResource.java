package com.jrm.campanhas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jrm.campanhas.domain.Campanha;
import com.jrm.campanhas.repository.CampanhasRepository;

@RestController
@RequestMapping("/campanhas")
public class CampanhasResource {

	@Autowired
	private CampanhasRepository campanhasRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Campanha> listar() {
		return campanhasRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Campanha campanha) {
		campanhasRepository.save(campanha);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Campanha buscar(@PathVariable("id") Long id) {
		return campanhasRepository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable("id") Long id) {
		campanhasRepository.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Campanha campanha, @PathVariable("id") Long id) {
		campanha.setId(id);
		campanhasRepository.save(campanha);
	}
}
