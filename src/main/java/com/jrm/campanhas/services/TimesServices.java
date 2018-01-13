package com.jrm.campanhas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrm.campanhas.domain.Time;
import com.jrm.campanhas.repository.TimesRepository;
import com.jrm.campanhas.services.exceptions.TimeExistenteException;
import com.jrm.campanhas.services.exceptions.TimeNaoEncontradoException;

@Service
public class TimesServices {

	@Autowired
	private TimesRepository timesRepository;

	public List<Time> listar() {
		return timesRepository.findAll();
	}

	public Time salvar(Time time) {
		if (time.getId() != null) {
			Time t = timesRepository.findOne(time.getId());

			if (t != null) {
				throw new TimeExistenteException("Time já existe.");
			}
		}
		return timesRepository.save(time);
	}

	public Time buscar(Long id) {
		Time time = timesRepository.findOne(id);
		
		if(time == null) {
			throw new TimeNaoEncontradoException("O Time não pode ser encontrado.");
		}
		
		return time;
	}
}
