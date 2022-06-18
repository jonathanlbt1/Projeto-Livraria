package com.gft.minhaloja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.minhaloja.entities.Escritor;
import com.gft.minhaloja.repositories.EscritorRepository;

@Service
public class EscritorService {

	@Autowired
	EscritorRepository escritorRepository;
	
	
    public Escritor salvarEscritor(Escritor escritor) {

        return escritorRepository.save(escritor);
    }
    
    
    
    public List<Escritor> listarEscritores() {

        return escritorRepository.findAll();
    }
    
    
    
    public Escritor obterEscritor(Long id) throws Exception {

        Optional<Escritor> escritores = escritorRepository.findById(id);
        if (escritores.isEmpty()) {
            throw new Exception("Escritor não encontrado");
        }

        return escritores.get();
    }
    
    
  
    public void excluirEscritor(Long id) {
    	
        escritorRepository.deleteById(id);
    }
}
