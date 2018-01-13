package com.jrm.campanhas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jrm.campanhas.domain.Time;
import com.jrm.campanhas.services.TimesServices;

@RestController
@RequestMapping("/times")
public class TimesResources {

	@Autowired
	private TimesServices timesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Time>> listar(){
		List<Time> times = timesService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(times);
	}
	
}
