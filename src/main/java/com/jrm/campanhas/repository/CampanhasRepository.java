package com.jrm.campanhas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrm.campanhas.domain.Campanha;

public interface CampanhasRepository extends JpaRepository<Campanha, Long>{
	
	public List<Campanha> findByfimVigenciaBetween(Date inicio, Date fim);
	
	public List<Campanha> findByfimVigenciaAfter(Date fim);
	
}
