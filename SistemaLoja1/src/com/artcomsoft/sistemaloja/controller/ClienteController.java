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
import com.artcomsoft.sistemaloja.models.dao.ClienteDaoImpl;


@Controller
@Transactional
public class ClienteController {

	@Autowired
	private ClienteDaoImpl clienteDao ;

	@RequestMapping(value="/Cliente",method=RequestMethod.GET)
	public ModelAndView adicionar(Model model) {
		model.addAttribute("obj",new Cliente());
		ModelAndView modelAndView = new ModelAndView ("formularocliente/CadastroCliente");
		return  modelAndView;      
	}
	@RequestMapping(value ="/adicionarCliente", method=RequestMethod.POST)
	public  ModelAndView save (@Valid @ModelAttribute("obj") Cliente obj,BindingResult bindingResult,RedirectAttributes redirectAttributes) {  

		if(bindingResult.hasErrors()){
			//return  new ModelAndView("FormularioUsuario/AdministratorPage");
		}
		clienteDao.salvarObjeto(obj);
		System.out.println (obj.getIdCliente());
		redirectAttributes.addFlashAttribute( "idCliente", obj.getIdCliente());
		redirectAttributes.addFlashAttribute("sucesso",
				"Usuario cadastrado com sucesso");
		return new  ModelAndView("formularocliente/CadastroEndereco"); 
	}    	


}
