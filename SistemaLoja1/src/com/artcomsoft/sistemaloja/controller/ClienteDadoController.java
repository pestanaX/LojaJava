package com.artcomsoft.sistemaloja.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.artcomsoft.sistemaloja.models.Cliente;
import com.artcomsoft.sistemaloja.models.Endereco;
import com.artcomsoft.sistemaloja.models.Funcao;
import com.artcomsoft.sistemaloja.models.dao.ClienteDaoImpl;
import com.artcomsoft.sistemaloja.models.dao.EnderecoDaoImpl;


@Controller
@Transactional
public class ClienteDadoController {

	@Autowired
	private ClienteDaoImpl clienteDao ;

	@Autowired
	private EnderecoDaoImpl enderecoDao ;

	private Endereco enderecoAlterado=new Endereco();
	@RequestMapping(value ="/Dados")
	private String tentaIndex() {
		return "formularocliente/ClienteDado";
	}
	@RequestMapping(value="/alterarDadosCliente",method=RequestMethod.GET)
	public ModelAndView alterarDadosCliente() {		
		return new ModelAndView("formularocliente/AlterarDadosCliente");
	}
	@RequestMapping(value="/alterarCliente",method=RequestMethod.POST)
	public ModelAndView novoDadosCliente(Cliente cliente ,@RequestParam("senhaAntiga") String senhaAntiga,
			@RequestParam("senhaNova") String senhaNova ) {

		Cliente clienteTest  = new Cliente();
		clienteTest = (Cliente) clienteDao.getId(cliente.getIdCliente());
		if (clienteTest.getSenha().equals(senhaAntiga)) 
			if (cliente.getSenha().equals(senhaNova)) {
				clienteDao.atualizarObjeto(cliente);			
			}
		return new ModelAndView("formularocliente/ClienteDado");
	}
	@RequestMapping(value="/mostraEndereco",method=RequestMethod.GET)
	public ModelAndView mostraEndereco(int id,Model model) throws  Exception {		

		try { 
			if (enderecoDao.procurarIdCliente(id).getCliente().getIdCliente()==id) {

				enderecoAlterado=enderecoDao.procurarIdCliente(id);
				model.addAttribute("endereco", enderecoDao.procurarIdCliente(id));
				return new ModelAndView("formularocliente/MostrarEndereco");
			}
		} catch (Exception ex) {
			model.addAttribute("obj",new Endereco());
			return new ModelAndView("formularocliente/CadastroEndereco");
		}
		return new ModelAndView("formularocliente/MostrarEndereco");
	}
	@RequestMapping(value="/alterarEndereco",method=RequestMethod.GET)
	public ModelAndView alterarEndereco( Model model) {

		model.addAttribute("endereco", enderecoAlterado); 
		model.addAttribute("obj",new Endereco());
		return new ModelAndView("formularocliente/AlterarEnderecoCliente");
	}

	@RequestMapping(value ="/alterarEndereco",method=RequestMethod.POST)
	public  ModelAndView alterarEndereco (@Valid @ModelAttribute("obj") Endereco obj,
			Model model,RedirectAttributes redirectAttributes) {

		enderecoDao.atualizarObjeto(obj);
		redirectAttributes.addFlashAttribute("sucesso",
				"Endereço Alterado com sucesso");
		return new ModelAndView("formularocliente/PaginaCliente");
	}

}
