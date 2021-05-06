package com.segplano.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.segplano.api.model.Apolice;

public interface ApoliceDao extends JpaRepository<Apolice, Long>{

	public Apolice findByPlaca(String placa);
	
	@Query("select apo from Apolice apo where apo.fimVigencia < current_date() order by apo.fimVigencia")
	public List<Apolice> listarApolicesVencidas();

}
