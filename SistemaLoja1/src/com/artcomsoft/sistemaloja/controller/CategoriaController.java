package com.artcomsoft.sistemaloja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.artcomsoft.sistemaloja.models.Categoria;
import com.artcomsoft.sistemaloja.models.Funcao;
import com.artcomsoft.sistemaloja.models.dao.CategoriaDaoImpl;


@Controller
@Transactional
public class CategoriaController {

	@Autowired
	private CategoriaDaoImpl categoriaDao ;

	@RequestMapping(value="/Categoria",method=RequestMethod.GET)
	public ModelAndView adicionar(Model model) {
		model.addAttribute("obj",new Categoria());
		ModelAndView modelAndView = new ModelAndView ("Funciolanidades/CategoriaProduto/CategoriaDeProduto");
		return  modelAndView;      
	}
	@RequestMapping(value ="/adicionarCategoria", method=RequestMethod.POST)
	public  ModelAndView save (@Valid @ModelAttribute("obj") Categoria obj,BindingResult bindingResult,RedirectAttributes redirectAttributes) {  

		if(bindingResult.hasErrors()){
			return  new ModelAndView("Funciolanidades/CategoriaProduto/CategoriaDeProduto");
		}
		categoriaDao.salvarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Funcionalidade cadastrado com sucesso");

		return list();
	}
	@RequestMapping(value="/ListaCategoria",method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("Funciolanidades/CategoriaProduto/ListaCategoria");	
		modelAndView.addObject("categoria", categoriaDao.listagensCategoria());		
		return modelAndView;
	}
	@RequestMapping(value="/mostraCategoria",method=RequestMethod.GET)
	public ModelAndView mostraCategoria(int id, Model model) {        
		model.addAttribute("categoria", categoriaDao.getId(id));
		return new ModelAndView( "Funciolanidades/CategoriaProduto/MostraCategoria");
	}
	@RequestMapping(value ="/alterarCategoria",method=RequestMethod.POST)
	public  ModelAndView alterarCategoria (Categoria obj,RedirectAttributes redirectAttributes) {	   
		categoriaDao.atualizarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Categoria Alterada com sucesso");
		return list();
	}


}
