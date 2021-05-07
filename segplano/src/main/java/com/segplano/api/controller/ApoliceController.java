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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.segplano.api.exception.ApoliceNaoExisteException;
import com.segplano.api.model.Apolice;
import com.segplano.api.service.ApoliceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/apolices")
@Api("API REST de Apólices")
public class ApoliceController {

	@Autowired
	ApoliceService apoliceService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Salva uma nova apólice")
	public void salvar(@RequestBody @Valid Apolice apolice) throws Exception {	
		apoliceService.salvar(apolice);
	}
	
	@GetMapping
	@ApiOperation("Lista todas as apólices")
	public List<Apolice> listarApolices() {
		return apoliceService.listar();
	}
	
	@GetMapping("/vencidas")
	@ApiOperation("Lista todas as apólices vencidas")
	public List<Apolice> listarApolicesVencidas() {
		return apoliceService.listarApolicesVencidas();
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Recupera uma apólice por seu id")
	public Apolice getApoliceById(@PathVariable Long id) throws ApoliceNaoExisteException {
	    Apolice apolice = apoliceService.getApoliceById(id);       		
	    
	    return apolice;
	}
	
	@GetMapping("/numero/{numero}")
	@ApiOperation("Recupera uma apólice por seu numero")
	public @ResponseBody Apolice getApoliceByNumero(@PathVariable String numero) throws ApoliceNaoExisteException {
		return apoliceService.getApoliceByNumero(numero);       		
	}
	
	@GetMapping("/placa/{placa}")
	@ApiOperation("Recupera uma apólice pela placa do veículo")
	public @ResponseBody Apolice getApoliceByPlaca(@PathVariable String placa) throws ApoliceNaoExisteException {
		return apoliceService.getApoliceByPlaca(placa);       		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Deleta uma apólice pelo seu id")
	public void deleteById(@PathVariable Long id) { //throws ClienteNotFoundException {
		apoliceService.deleteById(id);
	}
	
	@PatchMapping()
	@ApiOperation("Altera dados de uma apólice")
	public void alterar(@RequestBody @Valid Apolice apolice) throws Exception {
		if(apoliceService.getApoliceById(apolice.getId()) == null) {
			throw new Exception("Apólice não encontrada");
		}
		
		apoliceService.atualizar(apolice);    
	}   
    
}
