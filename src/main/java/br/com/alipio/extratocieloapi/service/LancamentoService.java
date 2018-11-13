package br.com.alipio.extratocieloapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alipio.extratocieloapi.model.Lancamento;
import br.com.alipio.extratocieloapi.repository.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;

	public List<Lancamento> getLancamentos() {
		return repository.findAll();
	}
	
	public Lancamento getLancamento(String id) {
		return repository.findByID(id);
	}

}
