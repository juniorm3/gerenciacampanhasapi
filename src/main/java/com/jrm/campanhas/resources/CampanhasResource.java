package com.jrm.campanhas.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jrm.campanhas.domain.Campanha;

@RestController
public class CampanhasResource {

	@RequestMapping(value = "/campanhas", method = RequestMethod.GET)
	public List<Campanha> listar() {

		Campanha c1 = new Campanha("Campeonato Paulista");
		Campanha c2 = new Campanha("Capa SP Junior");

		Campanha[] campanhas = { c1, c2 };

		return Arrays.asList(campanhas);
	}
}
