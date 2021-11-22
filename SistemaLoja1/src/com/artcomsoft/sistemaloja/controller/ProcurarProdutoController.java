package com.artcomsoft.sistemaloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.artcomsoft.sistemaloja.models.Produto;
import com.artcomsoft.sistemaloja.models.dao.ProdutoDaoImpl;

@Controller
@Transactional

public class ProcurarProdutoController {

	@Autowired
	private  ProdutoDaoImpl produtoDao ;

	@RequestMapping("/ProcurarProduto") 
	 public ModelAndView form() {
		return new ModelAndView("Funciolanidades/CadrastramentoProduto/ProcurarProduto");
	}	
	
	@RequestMapping(value ="/procurarProduto")
	public ModelAndView procurarProduto(@RequestParam String descricao,@RequestParam String codigo, Model model) {
		
		Produto produtoObjeto = new Produto();
		Produto produtoObjeto1 = new Produto();
	   	
		produtoObjeto=produtoDao.descricaoProduto(descricao);
		//produtoObjeto1=produtoDao.codigoProduto(codigo);		
		model.addAttribute("produto",produtoObjeto);
		//model.addAttribute("codigoproduto",produtoObjeto1);		
		return new ModelAndView("Funciolanidades/CadrastramentoProduto/MostrarPesquisa");

	}

}
