package com.artcomsoft.sistemaloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.artcomsoft.sistemaloja.models.Fornecidor;
import com.artcomsoft.sistemaloja.models.dao.FornecidorDaoImpl;

@Controller
@Transactional
public class ProcurarFonecidorController {
	@Autowired
	private FornecidorDaoImpl fornecidorDao ;

	@RequestMapping("/ProcurarFornecidor") 
	 public ModelAndView form() {
		return new ModelAndView("Funciolanidades/Fornecidor/ProcurarFornecidor");
	}	
	
	@RequestMapping(value ="/procurarFornecidor")
	public ModelAndView procurarFornecidor(@RequestParam String nome, Model model) {
		
		Fornecidor fornecidorObjeto = new Fornecidor();	
		fornecidorObjeto=fornecidorDao.nomeFornecidor(nome);		
		model.addAttribute("fornecidor",fornecidorObjeto);
		System.out.println(fornecidorObjeto.getNomeDoFornecidor());
		return new ModelAndView("Funciolanidades/Fornecidor/MostrarPesquisa");

	}


}
