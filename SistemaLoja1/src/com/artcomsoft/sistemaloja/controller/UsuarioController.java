package com.artcomsoft.sistemaloja.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.artcomsoft.sistemaloja.models.Administrador;
import com.artcomsoft.sistemaloja.models.Funcao;
import com.artcomsoft.sistemaloja.models.dao.AdiministradorDaoImpl;
import com.artcomsoft.sistemaloja.models.dao.FuncaoDaoImpl;



@Controller
@Transactional
public class UsuarioController {


	@Autowired
	private AdiministradorDaoImpl administrador;
	@Autowired
	private FuncaoDaoImpl funcaoDao;


	@RequestMapping(value="/Usuario",method=RequestMethod.GET)
	public ModelAndView adicionar(Model model) throws IOException {
		model.addAttribute("obj",new Administrador());		
		ModelAndView modelAndView = new ModelAndView ("FormularioUsuario/AdministratorPage");		
		modelAndView.addObject("funcoes" ,funcaoDao.listagensObjeto());
		//Arquivo.criarArquivo("imagens");
		return  modelAndView;      
	}
	@RequestMapping(value ="/adicionarUsuario", method=RequestMethod.POST)
	public  ModelAndView save (@Valid @ModelAttribute("obj") Administrador obj,BindingResult bindingResult,RedirectAttributes redirectAttributes) {  

		System.out.println(obj.getFuncaoAdministrador().get(0).getDescricao());
		if(bindingResult.hasErrors()){
			//return  new ModelAndView("FormularioUsuario/AdministratorPage");
		}
		administrador.salvarObjeto(obj);		
		redirectAttributes.addFlashAttribute("sucesso",
				"Usuario cadastrado com sucesso");		

		return new ModelAndView("FormularioUsuario/AdministratorPage");
	}    	
	 
	
}
