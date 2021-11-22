package com.artcomsoft.sistemaloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.artcomsoft.sistemaloja.models.Funcao;
import com.artcomsoft.sistemaloja.models.dao.FuncaoDaoImpl;

@Controller
@Transactional
public class ProcurarFuncaoController {
	
	@Autowired
	private FuncaoDaoImpl funcaoDao ;

	@RequestMapping("/ProcurarFuncao") 
	 public ModelAndView form() {
		return new ModelAndView("FormularioFuncao/ProcurarFuncao");
	}	
	
	@RequestMapping(value ="/procurarFuncao")
	public ModelAndView procurarFuncao(@RequestParam String descricao, Model model) {
		
		Funcao funcaoObjeto = new Funcao();
		funcaoObjeto=funcaoDao.descricaoFuncao(descricao);
		
		System.out.println(descricao);
		model.addAttribute("funcao",funcaoObjeto);
		//System.out.println(funcaoObjeto.getId_funcao());
		return new ModelAndView("FormularioFuncao/MostrarPesquisa");

	}

}
