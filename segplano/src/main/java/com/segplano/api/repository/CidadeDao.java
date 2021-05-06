package com.segplano.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segplano.api.model.Cidade;
import com.segplano.api.model.Estado;

public interface CidadeDao extends JpaRepository<Cidade, Long> {

	public Cidade findByNome(String nome);

	public List<Cidade> findByEstado(Estado estado);
	
}
