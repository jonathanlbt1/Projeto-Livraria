package com.gft.minhaloja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.minhaloja.entities.Livro;
import com.gft.minhaloja.services.LivroService;

@Controller
@RequestMapping("livro")
public class LivroController {

	
	@Autowired
	LivroService livroService;
	
	
	
	@RequestMapping("lista")
	public ModelAndView listarLivros() {
		ModelAndView mView = new ModelAndView("livro/listar.html");
		mView.addObject("livro", livroService.listarLivro());
		
		return mView;
	}
	
	
	
	@RequestMapping(path = "/editar")
	public ModelAndView editarLivro(@RequestParam(required = false) Long id) {
		
		ModelAndView mView = new ModelAndView("livro/form.html");
		Livro livro;
		
        if (id == null) {
            livro = new Livro();
        } else {
            try {
                livro = livroService.obterLivro(id);
            } catch (Exception e) {
                livro = new Livro();
                mView.addObject("mensagem", e.getMessage());
            }
        }
		
		mView.addObject("livro", livro);
		
		return mView;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/editar")
	public ModelAndView salvarLivro(@Valid Livro livro, BindingResult bindingResult) {
		
		ModelAndView mView = new ModelAndView("livro/form.html");
		
		boolean novo = true;
		
		if(livro.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mView .addObject("livro", livro);
			return mView ;
		}
		
		livroService.salvarLivro(livro);
		
		if(novo) {
			mView .addObject("livro", new Livro());
		} else {
			mView .addObject("livro", livro);
		}
		
		
		mView .addObject("mensagem", "Livro salvo com sucesso");
		
		return mView ;
		
	}
	
	

	@RequestMapping("/excluir")
	public ModelAndView excluirLivro(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mView = new ModelAndView("redirect:/livro");
		
		try {
			livroService.excluirLivro(id);
			redirectAttributes.addFlashAttribute("mensagem", "Livro excluido com sucesso");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir livro!" + e.getMessage());
		}
		
		return mView;
	}

}
