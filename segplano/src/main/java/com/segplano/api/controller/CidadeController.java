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

import com.segplano.api.model.Cidade;
import com.segplano.api.model.Estado;
import com.segplano.api.service.CidadeService;

@RestController
@RequestMapping("api/cidades")
public class CidadeController {

	@Autowired
	CidadeService cidadeService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Valid Cidade cidade) throws Exception {		
		cidadeService.salvar(cidade);
	}
	
	@GetMapping
	public List<Cidade> listarCidades() {
		return cidadeService.listar();
	}
	
	@GetMapping("/estado/{estado}")
	public List<Cidade> listarCidadesPorIdEstado(@PathVariable Estado estado) {
		return cidadeService.listarPorEstado(estado);
	}
	
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cidade getCidadeById(@PathVariable Long id) throws Exception { //throws ClienteNotFoundException {
        Cidade cidade = cidadeService.getById(id)
        		.orElseThrow(() -> new Exception("Cidade não encontrada"));
        
        return cidade;
    }
	
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) { //throws ClienteNotFoundException {
        cidadeService.deleteById(id);
    }
    
    @PatchMapping()
    public void alterar(@RequestBody @Valid Cidade cidade) throws Exception {
    	cidadeService.getById(cidade.getId())
    		.orElseThrow(() -> new Exception("Cidade não encontrada ao editar"));
    	
    	cidadeService.atualizar(cidade);    
    }
    
    
}
