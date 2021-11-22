package com.artcomsoft.sistemaloja.controller;

import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.artcomsoft.sistemaloja.controller.Componentes.Cadeia;
import com.artcomsoft.sistemaloja.models.Categoria;
import com.artcomsoft.sistemaloja.models.EnderecoFornecidor;
import com.artcomsoft.sistemaloja.models.Fornecidor;
import com.artcomsoft.sistemaloja.models.dao.CategoriaDaoImpl;
import com.artcomsoft.sistemaloja.models.dao.EnderecoFornecidorDaoImpl;
import com.artcomsoft.sistemaloja.models.dao.FornecidorDaoImpl;
import com.artcomsoft.sistemaloja.models.validacao.ValidarFuncao;

@Controller
@Transactional
public class FornecidorController {

	@Autowired
	private FornecidorDaoImpl fornecidorDao ;

	@Autowired
	private EnderecoFornecidorDaoImpl enderecoDao ;

	/*@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ValidarFuncao());
	}
	 */
	@RequestMapping(value="/Fornecidor",method=RequestMethod.GET)
	public ModelAndView adicionar(Model model) {
		model.addAttribute("obj",new Fornecidor());
		ModelAndView modelAndView = new ModelAndView ("Funciolanidades/Fornecidor/FornecidorPage");
		return  modelAndView;      
	}
	@RequestMapping(value ="/adicionarFornecidor", method=RequestMethod.POST)
	public  ModelAndView save (@Valid @ModelAttribute("obj") Fornecidor obj,BindingResult bindingResult,RedirectAttributes redirectAttributes) {  

		obj.setDataCriacao(new Date());
		if(bindingResult.hasErrors()){
			return  new ModelAndView("Funciolanidades/Fornecidor/FornecidorPage");
		}

		fornecidorDao.salvarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Funcionalidade cadastrado com sucesso");

		return list();
	}
	@RequestMapping(value="/ListaFornecidor",method=RequestMethod.GET)
	public ModelAndView list(){

		ModelAndView modelAndView = new ModelAndView("Funciolanidades/Fornecidor/ListaFornecidor");	
		modelAndView.addObject("fornecidor", fornecidorDao.listagensFornecidor());		
		return modelAndView;
	}
	@RequestMapping(value="/mostraFornecidor",method=RequestMethod.GET)
	public ModelAndView mostraFornecidor(int id, Model model) {        
		model.addAttribute("fornecidor", fornecidorDao.getId(id));
		return new ModelAndView( "Funciolanidades/Fornecidor/MostraFornecidor");
	}

	@RequestMapping(value ="/alterarFornecidor",method=RequestMethod.POST)
	public  ModelAndView alterarCategoria (@RequestParam("idFornecidor") int id ,Fornecidor obj,RedirectAttributes redirectAttributes) {	   

		Fornecidor fornecidorAtual = new Fornecidor();
		fornecidorAtual = (Fornecidor) fornecidorDao.getId(id);
		obj.setDataCriacao(fornecidorAtual.getDataCriacao());
		obj.setDataModificacao(new Date());

		fornecidorDao.atualizarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Categoria Alterada com sucesso");
		return list();
	}

	@RequestMapping(value="/adicionarEnderecoFornecidor",method=RequestMethod.GET)
	public ModelAndView adicionarEnderecoFornecidor(int id, Model model) {           

		try {
			if (enderecoDao.procurarIdFornecidor(id).getFornecidor().getIdFornecidor()==id) {				
				model.addAttribute("dadosEndereco", enderecoDao.procurarIdFornecidor(id));			
				return new ModelAndView("Funciolanidades/Fornecidor/MostrarEndereco");
			}
		} catch (Exception ex) {
			model.addAttribute("obj",new EnderecoFornecidor ());
			model.addAttribute("dados", id);
			return new ModelAndView("Funciolanidades/Fornecidor/EndFornecidor");
		}
		return new ModelAndView();
	}


}
