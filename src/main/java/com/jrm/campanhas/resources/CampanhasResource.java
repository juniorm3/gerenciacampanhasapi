package com.jrm.campanhas.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampanhasResource {

	@RequestMapping(value = "/campanhas", method = RequestMethod.GET)
	public String listar() {
		return "Rest Applicado, Git passo-a-passo";
	}
}
