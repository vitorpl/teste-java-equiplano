package com.segplano.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.segplano.api.model.Cliente;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClienteCpfJaExisteException extends Exception {

	private static final long serialVersionUID = 4911643567744512000L;

	public ClienteCpfJaExisteException(Cliente cliente) {
		super(String.format("Já existe cliente para o cpf %s registrado no sistema.", cliente.getCpf()));
	}
}
