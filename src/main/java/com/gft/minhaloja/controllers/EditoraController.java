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
import com.gft.minhaloja.entities.Livro;
import com.gft.minhaloja.repositories.EditoraRepository;
import com.gft.minhaloja.services.EditoraService;

@Controller
@RequestMapping("editora")
public class EditoraController {

	
	@Autowired
	EditoraService editoraService;
	
	

	@RequestMapping("lista")
	public ModelAndView listarEditoras() {
		ModelAndView mView = new ModelAndView("editora/listar.html");
		mView.addObject("editora", editoraService.listarEditoras());
		
		return mView;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarEditora(@Valid Editora editora, BindingResult bindingResult) {
		
		ModelAndView mView = new ModelAndView("editora/form.html");
		
		boolean novo = true;
		
		if(editora.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mView .addObject("editora", editora);
			return mView ;
		}
		
		editoraService.salvarEditora(editora);
		
		if(novo) {
			mView .addObject("editora", new Editora());
		} else {
			mView .addObject("editora", editora);
		}
		
		
		mView .addObject("mensagem", "Editora salva com sucesso");
		
		return mView ;
		
	}
	
	
	
	
	@RequestMapping("/editar")
	public ModelAndView editarEditora(@RequestParam Long id) {
		
		ModelAndView mView = new ModelAndView("editora/form.html");
		Editora editora;
		
		try {
			editora = editoraService.obterEditora(id);
		} catch (Exception e) {
			editora = new Editora();
			mView.addObject("mensagem", e.getMessage());
		}
		
		mView.addObject("editora", editora);
		
		return mView;
	}
	
	


	@RequestMapping("/excluir")
	public ModelAndView excluirEditora(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mView = new ModelAndView("redirect:/editora");
		
		try {
			editoraService.excluirEditora(id);
			redirectAttributes.addFlashAttribute("mensagem", "Editora excluida com sucesso");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir editora!" + e.getMessage());
		}
		
		return mView;
	}

}
