package com.segplano.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApoliceJaExisteException extends Exception {

	private static final long serialVersionUID = 4911643567744512000L;

	public ApoliceJaExisteException(String placaVeiculo) {
		super(String.format("Já existe uma apólice para o veículo de placa %s registrada no sistema.", placaVeiculo));
	}
}
