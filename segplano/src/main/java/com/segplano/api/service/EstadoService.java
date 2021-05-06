package com.segplano.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.segplano.api.model.Estado;
import com.segplano.api.repository.EstadoDao;

@Service
public class EstadoService {

	@Autowired
	private EstadoDao dao;
	
	
	public void salvar(Estado estado) throws Exception {
		//validar cpf
		if(dao.findByNome(estado.getNome()) != null || dao.findBySigla(estado.getSigla()) != null)  {
			throw new Exception("Estado já existe estado com este Nome ou Sigla");
		}
		
		dao.save(estado);
	}
	
	public void atualizar(Estado estado) {
		dao.save(estado);
	}
	
	public List<Estado> listar() {
		return dao.findAll();
	}

	public void deleteById(Long id) {
		dao.deleteById(id);		
	}

	public Optional<Estado> getById(Long id) {
		return dao.findById(id);
	}
	
}
