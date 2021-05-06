package com.segplano.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.segplano.api.model.Cidade;
import com.segplano.api.model.Estado;
import com.segplano.api.repository.CidadeDao;

@Service
public class CidadeService {

	@Autowired
	private CidadeDao dao;
	
	
	public void salvar(Cidade cidade) throws Exception {
		//validar cpf
		if(dao.findByNome(cidade.getNome()) != null) {
			throw new Exception("Já existe cidade com este nome");
		}
		
		dao.save(cidade);
	}
	
	public void atualizar(Cidade cidade) {
		dao.save(cidade);
	}
	
	public List<Cidade> listar() {
		return dao.findAll();
	}

	public void deleteById(Long id) {
		dao.deleteById(id);		
	}

	public Optional<Cidade> getById(Long id) {
		return dao.findById(id);
	}

	public List<Cidade> listarPorEstado(Estado estado) {
		return dao.findByEstado(estado);
	}
	
}
