package com.jrm.campanhas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrm.campanhas.domain.Campanha;

public interface CampanhasRepository extends JpaRepository<Campanha, Long>{

}
