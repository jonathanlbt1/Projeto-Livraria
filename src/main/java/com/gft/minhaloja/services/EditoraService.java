package com.gft.minhaloja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.minhaloja.entities.Editora;
import com.gft.minhaloja.repositories.EditoraRepository;


@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRepository;
	
	
    public Editora salvarEditora(Editora editora) {

        return editoraRepository.save(editora);
    }
    
    
    
    public List<Editora> listarEditoras() {

        return editoraRepository.findAll();
    }
    
    
    
    public Editora obterEditora(Long id) throws Exception {

        Optional<Editora> editoras = editoraRepository.findById(id);
        if (editoras.isEmpty()) {
            throw new Exception("Editora não encontrada");
        }

        return editoras.get();
    }
    
    
  
    public void excluirEditora(Long id) {
    	
        editoraRepository.deleteById(id);
    }
}
