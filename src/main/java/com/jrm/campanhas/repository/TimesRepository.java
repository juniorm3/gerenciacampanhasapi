package com.jrm.campanhas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrm.campanhas.domain.Time;

public interface TimesRepository extends JpaRepository<Time, Long>{

}
