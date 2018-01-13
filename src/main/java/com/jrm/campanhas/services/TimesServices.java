package com.jrm.campanhas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrm.campanhas.domain.Time;
import com.jrm.campanhas.repository.TimesRepository;

@Service
public class TimesServices {

	@Autowired
	private TimesRepository timesRepository;
	
	public List<Time> listar(){
		return timesRepository.findAll();
	}
	
	
}
