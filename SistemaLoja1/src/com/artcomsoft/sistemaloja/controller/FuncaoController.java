package com.artcomsoft.sistemaloja.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.artcomsoft.sistemaloja.models.Funcao;
import com.artcomsoft.sistemaloja.models.dao.FuncaoDaoImpl;
import com.artcomsoft.sistemaloja.models.validacao.ValidarFuncao;


@Controller
@Transactional

public class FuncaoController {

	@Autowired
	private FuncaoDaoImpl funcaoDao ;


	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ValidarFuncao());
	}	
	@RequestMapping(value="/Funcao",method=RequestMethod.GET)
	public ModelAndView adicionar(Model model) {
		model.addAttribute("obj",new Funcao());
		return new ModelAndView("FormularioFuncao/Funcao");      
	}

	@RequestMapping(value ="/adicionarFuncionalidades", method=RequestMethod.POST)
	public  ModelAndView save (@Valid @ModelAttribute("obj") Funcao obj,BindingResult bindingResult,RedirectAttributes redirectAttributes) {  

		if(bindingResult.hasErrors()){
			return  new ModelAndView("FormularioFuncao/Funcao");
		}
		funcaoDao.salvarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Funcionalidade cadastrado com sucesso");

		return list();
	}
	@RequestMapping(value="/ListaFuncionalidades",method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("FormularioFuncao/ListaFuncionalidades");	
		modelAndView.addObject("funcoes", funcaoDao.listagensObjeto());		
		return modelAndView;
	}
	@RequestMapping(value="/mostraFuncao",method=RequestMethod.GET)
	public ModelAndView mostraFuncao(int id, Model model) {        
		model.addAttribute("funcao", funcaoDao.getId(id));
		return new ModelAndView( "FormularioFuncao/mostraFuncao");
	}
	@RequestMapping(value ="/alterarFuncao",method=RequestMethod.POST)
	public  ModelAndView alterarFuncao (Funcao obj,RedirectAttributes redirectAttributes) {	   
		funcaoDao.atualizarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Funcionalidade Alterada com sucesso");
		return list();
	}

}


