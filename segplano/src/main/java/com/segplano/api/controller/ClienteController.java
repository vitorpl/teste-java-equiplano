package com.segplano.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.segplano.api.exception.ClienteNaoEncontradoException;
import com.segplano.api.exception.ExclusaoClienteComApolicesException;
import com.segplano.api.model.Cliente;
import com.segplano.api.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/clientes")
@Api("API REST de Clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Salva um novo cliente")
	public void salvar(@RequestBody @Valid Cliente cliente) throws Exception {
		clienteService.salvar(cliente);
	}
	
	@GetMapping
	@ApiOperation("Lista todos os clientes")
	public List<Cliente> listarClientes() {
		return clienteService.listar();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Recupera um cliente por seu id")
	public Cliente getClienteById(@PathVariable Long id) throws Exception { //throws ClienteNotFoundException {
	    Cliente cliente = clienteService.getClienteById(id)
	    		.orElseThrow(() -> new Exception("Cliente não encontrado"));
	    
	    return cliente;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Deleta um cliente por seu id")
	public void deleteById(@PathVariable Long id) throws ClienteNaoEncontradoException, ExclusaoClienteComApolicesException { //throws ClienteNotFoundException {
	    clienteService.deleteById(id);
	}
	
	@PatchMapping()
	@ApiOperation("Altera dados de um cliente")
	public void alterar(@RequestBody @Valid Cliente cliente) throws Exception {
		clienteService.getClienteById(cliente.getId())
			.orElseThrow(() -> new Exception("Cliente não encontrado ao editar"));
		
		clienteService.atualizar(cliente);    
	}    
}
