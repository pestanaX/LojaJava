package com.artcomsoft.sistemaloja.controller;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.artcomsoft.sistemaloja.controller.Componentes.Cadeia;
import com.artcomsoft.sistemaloja.models.Categoria;
import com.artcomsoft.sistemaloja.models.Endereco;
import com.artcomsoft.sistemaloja.models.Produto;
import com.artcomsoft.sistemaloja.models.dao.CategoriaDaoImpl;
import com.artcomsoft.sistemaloja.models.dao.ImagemDao;
import com.artcomsoft.sistemaloja.models.dao.ProdutoDaoImpl;


@Controller
@Transactional
public class ProdutoController {



	@Autowired
	private ProdutoDaoImpl produtoDao;

	@Autowired
	private CategoriaDaoImpl categoriaDao;

	@Autowired
	private ImagemDao imagemDao;


	@RequestMapping(value="/Produto",method=RequestMethod.GET)
	public ModelAndView adicionar(Model model) {

		model.addAttribute("obj",new Produto());
		model.addAttribute("categoria" ,categoriaDao.listagensCategoria());
		ModelAndView modelAndView = new ModelAndView ("Funciolanidades/CadrastramentoProduto/Produto");

		return  modelAndView;      
	}

	@RequestMapping(value ="/adicionarProduto", method=RequestMethod.POST)
	public  ModelAndView save (@Valid @ModelAttribute("obj") Produto obj, 
			BindingResult bindingResult,RedirectAttributes redirectAttributes) {

		System.out.println(obj.getDescricaoProduto());

		if(bindingResult.hasErrors()){
			return  new ModelAndView("Funciolanidades/CadrastramentoProduto/Produto");
		}
		produtoDao.salvarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Produto cadastrado com sucesso");
		return list();
	}
	@RequestMapping(value="/ListaProduto",method=RequestMethod.GET)
	public ModelAndView list(){
		
		ModelAndView modelAndView = new ModelAndView("Funciolanidades/CadrastramentoProduto/ListaProduto");	
		modelAndView.addObject("produto", produtoDao.listagensProduto());		
		return modelAndView;  
	}
	@RequestMapping(value="/mostraProduto",method=RequestMethod.GET)
	public ModelAndView mostraProduto(int id, Model model) { 
		
		model.addAttribute("obj",new Produto()); 
		model.addAttribute("categoria" ,categoriaDao.listagensCategoria());
		model.addAttribute("produto", produtoDao.getId(id));
		return new ModelAndView( "Funciolanidades/CadrastramentoProduto/MostraProduto");
	}
	@RequestMapping(value ="/alterarProduto",method=RequestMethod.POST)
	public  ModelAndView alterarCategoria (@Valid @ModelAttribute("obj") Produto obj,Model model,RedirectAttributes redirectAttributes) {	   


		produtoDao.atualizarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Produto Alterada com sucesso");
		return list();
	}
	@RequestMapping(value="/adicionarImagem",method=RequestMethod.GET)
	public ModelAndView adicionarImagem(int id, Model model) { 
            
		String listaImagens[] = new String[4];
		try { 
			if (imagemDao.procurarIdProduto(id).getProduto().getIdProduto()==id) {				
				
				listaImagens[0]=Cadeia.converterStringArray(imagemDao.procurarIdProduto(id).getImagemPrincipal());
				listaImagens[1]=Cadeia.converterStringArray(imagemDao.procurarIdProduto(id).getImagem1());
				listaImagens[2]=Cadeia.converterStringArray(imagemDao.procurarIdProduto(id).getImagem2());
				listaImagens[3]=Cadeia.converterStringArray(imagemDao.procurarIdProduto(id).getImagem3());       
				
				model.addAttribute("imagem", listaImagens);
				model.addAttribute("dadosImagem", imagemDao.procurarIdProduto(id));
				model.addAttribute("produto",produtoDao.getId(id));
				return new ModelAndView("Funciolanidades/CadrastramentoProduto/MostraImagem");
			}
		} catch (Exception ex) {
			System.out.println(ex); 
			model.addAttribute("imagem", produtoDao.getId(id));
			return new ModelAndView( "Funciolanidades/CadrastramentoProduto/ImagemProduto");
		}
		return new ModelAndView();
	}
    
	@RequestMapping(value="/alterarImagem",method=RequestMethod.GET)
	public ModelAndView alterarImagem(int id, Model model){
		
		model.addAttribute("imagem", imagemDao.getId(id));
		return new ModelAndView( "Funciolanidades/CadrastramentoProduto/AlterarImagem");
	}
}
