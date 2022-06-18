package com.gft.minhaloja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.minhaloja.services.LivrariaService;
import com.gft.minhaloja.services.LivroService;

@Controller
@RequestMapping("/livraria")
public class LivrariaController {

	
	@Autowired
	private LivrariaService livrariaService;
	
	@Autowired
	private LivroService livroService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarEscritores() {
		ModelAndView mView = new ModelAndView("layout.html");
		mView.addObject("message", "Bem vindo a Livraria Moraes");
		
		return mView;
	}
}
