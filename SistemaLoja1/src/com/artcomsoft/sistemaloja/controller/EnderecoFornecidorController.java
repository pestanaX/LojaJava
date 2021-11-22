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
import com.artcomsoft.sistemaloja.models.EnderecoFornecidor;
import com.artcomsoft.sistemaloja.models.dao.EnderecoFornecidorDaoImpl;



@Controller
@Transactional
public class EnderecoFornecidorController {

	@Autowired
	private EnderecoFornecidorDaoImpl enderecoDao ;

	@RequestMapping(value="/EndFornecidor",method=RequestMethod.GET)
	public ModelAndView adicionar(Model model) {
		model.addAttribute("obj",new EnderecoFornecidor());
		ModelAndView modelAndView = new ModelAndView ("Funciolanidades/Fornecidor/EndFornecidor");
		return  modelAndView;      
	}


	@RequestMapping(value ="/adicionarEnderecoFornecidor", method=RequestMethod.POST)
	public  ModelAndView save (@Valid @ModelAttribute("obj") EnderecoFornecidor obj,BindingResult bindingResult,RedirectAttributes redirectAttributes) {  

		if(bindingResult.hasErrors()){
			return  new ModelAndView("Funciolanidades/Fornecidor/EndFornecidor");
		}
		enderecoDao.salvarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Funcionalidade cadastrado com sucesso");
		return new ModelAndView("Funciolanidades/Fornecidor/MostrarEndereco"); 
	}
	
	
	@RequestMapping(value="/mostraEnderecoFornecidor",method=RequestMethod.GET)
	public ModelAndView mostraEnderecoFornecidor(int id, Model model) {        
		model.addAttribute("endereco", enderecoDao.getId(id));
		return new ModelAndView( "Funciolanidades/Fornecidor/AlterarEndereco");
	}
	
	@RequestMapping(value ="/alterarEnderecoFornecidor",method=RequestMethod.POST)
	public  ModelAndView alterarCategoria (EnderecoFornecidor obj,RedirectAttributes redirectAttributes) {	   
		
		enderecoDao.atualizarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Endereço Alterada com sucesso");
		return new ModelAndView("Funciolanidades/Fornecidor/MostrarEndereco");
	}


}
