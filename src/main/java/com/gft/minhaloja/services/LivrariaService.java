package com.gft.minhaloja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.minhaloja.entities.Livraria;
import com.gft.minhaloja.repositories.LivrariaRepository;

@Service
public class LivrariaService {

	@Autowired
	LivrariaRepository livrariaRepository;
	
	@Autowired
	LivroService livroService;
	
	
	
	public Livraria somarPatrimonio() {
		
		
		return null;
	}
}
