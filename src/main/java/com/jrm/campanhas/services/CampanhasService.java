package com.jrm.campanhas.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrm.campanhas.domain.Campanha;
import com.jrm.campanhas.repository.CampanhasRepository;
import com.jrm.campanhas.services.exceptions.CampanhaNaoEncontradaException;

@Service
public class CampanhasService {

	@Autowired
	private CampanhasRepository campanhasRepository;
	
	public List<Campanha> listar(){
		return campanhasRepository.findAll();
	}
	
	public List<Campanha> listarCampanhasVigentes(){	
		Calendar local = Calendar.getInstance();
		local.add(Calendar.DAY_OF_MONTH, -1);
		Date hoje = new Date(local.getTimeInMillis());
		
		List<Campanha> campanhasVigentes = new ArrayList<Campanha>();
		List<Campanha> campanhas = campanhasRepository.findAll();
		for(Campanha c : campanhas) {
			if(c.getFimVigencia().compareTo(hoje) >= 0) {
				campanhasVigentes.add(c);
			}
		}
		
		return campanhasVigentes;
	}
	
	public Campanha buscar(Long id) {
		Campanha campanha = campanhasRepository.findOne(id);
		
		if(campanha == null) {
			throw new CampanhaNaoEncontradaException("A campanha não pode ser encontrada.");
		}
		
		return campanha;
	}
	
	public Campanha salvar(Campanha campanha) {
		/*List<Campanha> vigentesNoPeriodo = campanhasRepository.findByfimVigenciaBetween(campanha.getInicioVigencia(), campanha.getFimVigencia());
		for(Campanha c : vigentesNoPeriodo) {
			if(c.getId() == campanha.getId()) {
				continue;
			}
		
			acrescentarDia(c);
			campanhasRepository.save(c);
		}*/
		
		campanha.setId(null);		
		return campanhasRepository.save(campanha);		
	}

	private Campanha acrescentarDia(Campanha c) {
		Calendar instancia = Calendar.getInstance();
		instancia.setTime(c.getFimVigencia());
		instancia.add(Calendar.DATE, 1);
		Date fim = new Date(instancia.getTimeInMillis());
		c.setFimVigencia(fim);
		return c;
	}
	
	public void deletar(Long id) {
		try {
			campanhasRepository.delete(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new  CampanhaNaoEncontradaException("A campanha não pode ser encontrada.");
		}
	}
	
	public void atualizar(Campanha campanha) {
		verificarExistencia(campanha);
		campanhasRepository.save(campanha);
	}
	
	private void verificarExistencia(Campanha campanha) {
		buscar(campanha.getId());
	}
}
