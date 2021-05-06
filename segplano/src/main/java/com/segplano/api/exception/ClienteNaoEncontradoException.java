package com.segplano.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.segplano.api.model.Cliente;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends Exception {

	private static final long serialVersionUID = -2458936503891430518L;

	public ClienteNaoEncontradoException(Cliente cliente) {
		super("Não foi encontrado um cliente com os parâmetros informados: "+cliente);		
	}
	
	public ClienteNaoEncontradoException(Long id) {
		super("Não foi encontrado um cliente com os parâmetros informados: ID: "+id);		
	}
	
}
