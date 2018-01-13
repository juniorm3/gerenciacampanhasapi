package com.jrm.campanhas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrm.campanhas.domain.TimeCoracao;
import com.jrm.campanhas.repository.TimesCoracaoRepository;
import com.jrm.campanhas.services.exceptions.TimeCoracaoExistenteException;
import com.jrm.campanhas.services.exceptions.TimeCoracaoNaoEncontradoException;

@Service
public class TimesCoracaoServices {

	@Autowired
	private TimesCoracaoRepository timesRepository;

	public List<TimeCoracao> listar() {
		return timesRepository.findAll();
	}

	public TimeCoracao salvar(TimeCoracao time) {
		if (time.getId() != null) {
			TimeCoracao t = timesRepository.findOne(time.getId());

			if (t != null) {
				throw new TimeCoracaoExistenteException("Time já existe.");
			}
		}
		return timesRepository.save(time);
	}

	public TimeCoracao buscar(Long id) {
		TimeCoracao time = timesRepository.findOne(id);
		
		if(time == null) {
			throw new TimeCoracaoNaoEncontradoException("O Time não pode ser encontrado.");
		}
		
		return time;
	}
}
