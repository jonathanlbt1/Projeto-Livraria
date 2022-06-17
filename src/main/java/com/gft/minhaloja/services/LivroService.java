package com.gft.minhaloja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.minhaloja.entities.Livro;
import com.gft.minhaloja.repositories.LivroRepository;

@Service
public class LivroService {

	
	@Autowired
	LivroRepository livroRepository;
	
	
	
    public Livro salvarLivro(Livro livro) {

        return livroRepository.save(livro);
    }
    
    
    
    public List<Livro> listarLivro() {

        return livroRepository.findAll();
    }
    
    
    
    public Livro obterLivro(Long id) throws Exception {

        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isEmpty()) {
            throw new Exception("Livro não encontrado");
        }

        return livro.get();
    }
    
    
    
    public Livro excluirLivro(Long id) {
        livroRepository.deleteById(id);
        return null;
    }
    
    
    public double calculaValor(){
    	
        List<Livro> livro = livroRepository.findAll();
        
        double sum = 0;

        for (int i = 0; i < listarLivro().size(); i++) {
            sum += livro.get(i).getPreco();
        }
        
        return sum;
    }
}
