package com.segplano.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segplano.api.model.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

	public Cliente findByCpf(String cpf);

}
