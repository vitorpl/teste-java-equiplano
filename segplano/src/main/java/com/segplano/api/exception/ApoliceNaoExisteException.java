package com.segplano.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApoliceNaoExisteException extends Exception {

	private static final long serialVersionUID = -2458936503891430518L;

	public ApoliceNaoExisteException(Long id) {
		super("Apólice não encontrada para o id: "+id);		
	}
	
	public ApoliceNaoExisteException(String codigo) {
		super("Apólice não encontrada para o codigo ou placa: "+codigo);		
	}
	
}
