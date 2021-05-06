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

import com.segplano.api.model.Apolice;
import com.segplano.api.service.ApoliceService;

@RestController
@RequestMapping("api/apolices")
public class ApoliceController {

	@Autowired
	ApoliceService apoliceService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Valid Apolice apolice) throws Exception {	
		apoliceService.salvar(apolice);
	}
	
	@GetMapping
	public List<Apolice> listarApolices() {
		return apoliceService.listar();
	}
	
	@GetMapping("/vencidas")
	public List<Apolice> listarApolicesVencidas() {
		return apoliceService.listarApolicesVencidas();
	}
	
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Apolice getApoliceById(@PathVariable Long id) throws Exception { //throws ClienteNotFoundException {
        Apolice apolice = apoliceService.getApoliceById(id);       		
        
        return apolice;
    }
	
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) { //throws ClienteNotFoundException {
    	apoliceService.deleteById(id);
    }
    
    @PatchMapping()
    public void alterar(@RequestBody @Valid Apolice apolice) throws Exception {
    	if(apoliceService.getApoliceById(apolice.getId()) == null) {
    		throw new Exception("Apólice não encontrada");
    	}
    	
    	apoliceService.atualizar(apolice);    
    }
    
    
}
