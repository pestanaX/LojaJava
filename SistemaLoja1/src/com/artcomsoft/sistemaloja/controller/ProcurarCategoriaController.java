package com.artcomsoft.sistemaloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.artcomsoft.sistemaloja.models.Categoria;
import com.artcomsoft.sistemaloja.models.dao.CategoriaDaoImpl;

@Controller
@Transactional
public class ProcurarCategoriaController {
	
	@Autowired
	private CategoriaDaoImpl categoriaDao ;

	@RequestMapping("/ProcurarCategoria") 
	 public ModelAndView form() {
		return new ModelAndView("Funciolanidades/CategoriaProduto/ProcurarCategoria");
	}	
	
	@RequestMapping(value ="/procurarCategoria")
	public ModelAndView procurarCategoria(@RequestParam String descricao, Model model) {
		
		Categoria categoriaObjeto = new Categoria();
		categoriaObjeto=categoriaDao.descricaoCategoria(descricao);
		
		System.out.println(descricao);
		model.addAttribute("categoria",categoriaObjeto);		
		return new ModelAndView("Funciolanidades/CategoriaProduto/MostrarPesquisa");

	}


}
