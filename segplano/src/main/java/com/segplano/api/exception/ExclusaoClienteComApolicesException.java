package com.segplano.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.segplano.api.model.Cliente;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExclusaoClienteComApolicesException extends Exception {

	private static final long serialVersionUID = -1113724874828024214L;
	
	public ExclusaoClienteComApolicesException(Cliente cliente) {
		super("O cliente não pode ser excluído pois possui apólices vinculadas");
	}

}
