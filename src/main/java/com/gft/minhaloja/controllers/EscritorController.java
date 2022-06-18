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

import com.gft.minhaloja.entities.Editora;
import com.gft.minhaloja.entities.Escritor;
import com.gft.minhaloja.repositories.EscritorRepository;
import com.gft.minhaloja.services.EscritorService;

@Controller
@RequestMapping("escritor")
public class EscritorController {

	@Autowired
	EscritorRepository escritorRepository;
	
	@Autowired
	EscritorService escritorService;
	
	
	@RequestMapping("lista")
	public ModelAndView listarEscritores() {
		ModelAndView mView = new ModelAndView("escritor/listar.html");
		mView.addObject("lista", escritorService.listarEscritores());
		
		return mView;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarEscritor(@Valid Escritor escritor, BindingResult bindingResult) {
		
		ModelAndView mView = new ModelAndView("escritor/form.html");
		
		boolean novo = true;
		
		if(escritor.getIdLong() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mView .addObject("escritor", escritor);
			return mView ;
		}
		
		escritorService.salvarEscritor(escritor);
		
		if(novo) {
			mView .addObject("escritor", new Escritor());
		} else {
			mView .addObject("escritor", escritor);
		}
		
		
		mView .addObject("mensagem", "Escritor salvo com sucesso");
		
		return mView ;
		
	}
	
	
	
	@RequestMapping("/editar")
	public ModelAndView editarEscritor(@RequestParam Long id) {
		
		ModelAndView mView = new ModelAndView("escritor/form.html");
		Escritor escritor;
		
		try {
			escritor = escritorService.obterEscritor(id);
		} catch (Exception e) {
			escritor = new Escritor();
			mView.addObject("mensagem", e.getMessage());
		}
		
		mView.addObject("escritor", escritor);
		
		return mView;
	}
	
	


	@RequestMapping("/excluir")
	public ModelAndView excluirEscritor(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mView = new ModelAndView("redirect:/escritor");
		
		try {
			escritorService.excluirEscritor(id);
			redirectAttributes.addFlashAttribute("mensagem", "Escritor excluida com sucesso");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir escritor!" + e.getMessage());
		}
		
		return mView;
	}
	
}
