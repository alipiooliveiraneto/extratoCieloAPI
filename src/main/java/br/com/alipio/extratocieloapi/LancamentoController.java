package br.com.alipio.extratocieloapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.alipio.extratocieloapi.model.Lancamento;
import br.com.alipio.extratocieloapi.service.LancamentoService;

@RestController
public class LancamentoController {
	
	@Autowired
	private LancamentoService service;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/lancamentos")
	List<Lancamento> getLancamentos(){
		return service.getLancamentos();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/lancamentos/{id}")
	Lancamento getLancamento(@PathVariable String id) {
		return service.getLancamento(id);
	}
}
