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

import com.segplano.api.model.Estado;
import com.segplano.api.service.EstadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/estados")
@Api("API REST de Estados")
public class EstadoController {

	@Autowired
	EstadoService estadoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Salva um novo estado")
	public void salvar(@RequestBody @Valid Estado estado) throws Exception {		
		estadoService.salvar(estado);
	}
	
	@GetMapping
	@ApiOperation("Lista todos os estados")
	public List<Estado> listarEstados() {
		return estadoService.listar();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Recupera um estado por seu id")
	public Estado getEstadoById(@PathVariable Long id) throws Exception { //throws ClienteNotFoundException {
	    Estado estado = estadoService.getById(id)
	    		.orElseThrow(() -> new Exception("Estado não encontrado"));
	    
	    return estado;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Deleta um estado por seu id")
	public void deleteById(@PathVariable Long id) { //throws ClienteNotFoundException {
	    estadoService.deleteById(id);
	}
	
	@PatchMapping()
	@ApiOperation("Altera dados de um estado")
	public void alterar(@RequestBody @Valid Estado estado) throws Exception {
		estadoService.getById(estado.getId())
			.orElseThrow(() -> new Exception("Estado não encontrada ao editar"));
		
		estadoService.atualizar(estado);    
	}
    
}
