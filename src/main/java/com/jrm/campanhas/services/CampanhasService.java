package com.jrm.campanhas.services;

import java.time.LocalDate;
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
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);		
		Date hoje = new Date(calendar.getTimeInMillis());
		
		return campanhasRepository.findByVigenciaAfter(hoje);
	}
	
	public Campanha buscar(Long id) {
		Campanha campanha = campanhasRepository.findOne(id);
		
		if(campanha == null) {
			throw new CampanhaNaoEncontradaException("A campanha não pode ser encontrada.");
		}
		
		return campanha;
	}
	
	public Campanha salvar(Campanha campanha) {
		campanha.setId(null);
		return campanhasRepository.save(campanha);		
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
