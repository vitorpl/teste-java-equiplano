package com.segplano.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.segplano.api.exception.ClienteCpfJaExisteException;
import com.segplano.api.exception.ClienteNaoEncontradoException;
import com.segplano.api.exception.ExclusaoClienteComApolicesException;
import com.segplano.api.model.Apolice;
import com.segplano.api.model.Cliente;
import com.segplano.api.repository.ApoliceDao;
import com.segplano.api.repository.ClienteDao;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao dao;
	
	@Autowired 
	private ApoliceDao apoliceDao;
	
	
	public void salvar(Cliente cliente) throws Exception {
		//validar cpf
		if(dao.findByCpf(cliente.getCpf()) != null) {
			throw new ClienteCpfJaExisteException(cliente);
		}
		
		dao.saveAndFlush(cliente);
	}
	
	public void atualizar(Cliente cliente) {
		dao.save(cliente);
	}
	
	public List<Cliente> listar() {
		return dao.findAll();
	}

	public void deleteById(Long id) throws ClienteNaoEncontradoException, ExclusaoClienteComApolicesException {
		
		Cliente cli = dao.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
		
		List<Apolice> aps = apoliceDao.findByCliente(cli);
		
		if(aps.size() > 0) {
			throw new ExclusaoClienteComApolicesException(cli);
		}
		
		dao.deleteById(id);		
	}

	public Optional<Cliente> getClienteById(Long id) {
		return dao.findById(id);
	}
	
}
