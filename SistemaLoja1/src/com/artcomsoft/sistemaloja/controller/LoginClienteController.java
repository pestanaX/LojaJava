package com.artcomsoft.sistemaloja.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.artcomsoft.sistemaloja.models.Cliente;
import com.artcomsoft.sistemaloja.models.dao.ClienteDaoImpl;

@Controller
@Transactional

public class LoginClienteController {
	@Autowired
	private ClienteDaoImpl clienteDao ;

	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public ModelAndView adicionar(Model model) {
		model.addAttribute("obj",new Cliente());
		ModelAndView modelAndView = new ModelAndView ("formularocliente/LoginCliente");
		return  modelAndView;      
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView iniciarSessao (@Valid @ModelAttribute("obj") Cliente cliente ,HttpSession sessao  ) throws Exception {

		Cliente clienteTest =  new Cliente ();
		ModelAndView pagina =new ModelAndView("formularocliente/PaginaCliente");
		clienteTest=clienteDao.procurarClienteEmail(cliente.getEmail());
		if (!clienteTest.equals(null)){			
			if (clienteTest.getSenha().equals(cliente.getSenha())) {
				sessao.setAttribute("clienteLogado", clienteTest);
				return pagina;
			} 

		} 
		return new ModelAndView("formularocliente/LoginCliente");

	} 




}
