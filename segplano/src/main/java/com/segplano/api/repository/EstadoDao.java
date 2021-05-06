package com.segplano.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segplano.api.model.Estado;

public interface EstadoDao extends JpaRepository<Estado, Long> {

	public Estado findByNome(String nome);
	public Estado findBySigla(String sigla);

}
