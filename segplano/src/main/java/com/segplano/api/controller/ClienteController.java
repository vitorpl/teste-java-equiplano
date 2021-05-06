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

import com.segplano.api.model.Cliente;
import com.segplano.api.service.ClienteService;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Valid Cliente cliente) throws Exception {		
		clienteService.salvar(cliente);
	}
	
	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteService.listar();
	}
	
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cliente getClienteById(@PathVariable Long id) throws Exception { //throws ClienteNotFoundException {
        Cliente cliente = clienteService.getClienteById(id)
        		.orElseThrow(() -> new Exception("Cliente não encontrado"));
        
        return cliente;
    }
	
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) { //throws ClienteNotFoundException {
        clienteService.deleteById(id);
    }
    
    @PatchMapping()
    public void alterar(@RequestBody @Valid Cliente cliente) throws Exception {
    	clienteService.getClienteById(cliente.getId())
    		.orElseThrow(() -> new Exception("Cliente não encontrado ao editar"));
    	
    	clienteService.atualizar(cliente);    
    }
    
    
}
