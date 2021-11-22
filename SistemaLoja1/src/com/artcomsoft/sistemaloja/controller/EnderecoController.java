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

import com.artcomsoft.sistemaloja.models.Cliente;
import com.artcomsoft.sistemaloja.models.Endereco;
import com.artcomsoft.sistemaloja.models.dao.EnderecoDaoImpl;

@Controller
@Transactional

public class EnderecoController {
	
	@Autowired
	
	private EnderecoDaoImpl enderecoDao;

	@RequestMapping(value="/Endereco",method=RequestMethod.GET)
	public ModelAndView adicionar(Model model) throws Exception {
		model.addAttribute("obj",new Endereco());
		ModelAndView modelAndView = new ModelAndView ("formularocliente/CadastroEndereco");
		return  modelAndView;      
	}

	@RequestMapping(value ="/adicionarEndereco", method=RequestMethod.POST)  
	public  ModelAndView save (@Valid @ModelAttribute("obj") Endereco obj,BindingResult 
			bindingResult,RedirectAttributes redirectAttributes) throws Exception {  
	
		System.out.println(obj.getBairro());
		if(bindingResult.hasErrors()){
			//return  new ModelAndView("FormularioUsuario/AdministratorPage");
		}
	
		enderecoDao.salvarObjeto(obj);		
		redirectAttributes.addFlashAttribute("sucesso",
				"Usuario cadastrado com sucesso");
		return new ModelAndView ("formularocliente/PaginaCliente");
	}  	

}

